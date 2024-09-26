from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.exceptions import InvalidSignature
import base64

def generate_signature(base_string, private_key_str, client_secret=None):
    from cryptography.hazmat.backends import default_backend

    # Load the PEM-encoded RSA private key
    if not isinstance(private_key_str, bytes):
        private_key_str = str.encode(private_key_str)

    password = None

    if client_secret:
        password = str.encode(client_secret)

    try:
        # Try loading the PEM-encoded RSA key with a passphrase
        from cryptography.hazmat.primitives import serialization

        private_key = serialization.load_pem_private_key(
            data=private_key_str,
            password=password,
            backend=default_backend()
        )
    except TypeError:
        # If the passphrase is not required
        from cryptography.hazmat.primitives import serialization

        private_key = serialization.load_pem_private_key(
            data=private_key_str,
            backend=default_backend()
        )

    # Sign the base string using RSA-SHA256
    signature = private_key.sign(
        msg=base_string.encode(),
        padding=padding.PSS(
            mgf=padding.MGF1(hashes.SHA256()),
            salt_length=padding.PSS.MAX_LENGTH
        ),
        algorithm=hashes.SHA256()
    )

    # Return the signature as a base64 encoded string
    return base64.b64encode(signature)

# Example usage
private_key_str = """-----BEGIN RSA PRIVATE KEY-----
...your private key here...
-----END RSA PRIVATE KEY-----"""
base_string = "Hello, World!"
client_secret = None

signature = generate_signature(base_string, private_key_str, client_secret)
print(signature)