import base64
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import rsa

def load_private_key(keydata):
    # Remove any additional encoding (like Base64) if necessary.
    keydata = base64.b64decode(keydata)  # Decode Base64 encoding

    return rsa.RSAPrivateKey.load_pem(
        pem_bytes=keydata,
        password=None,
        backend=default_backend()
    )

# Example usage:
private_key_b64 = "your_base64_encoded_private_key_here"
keydata = bytes(private_key_b64, 'utf-8')
loaded_key = load_private_key(keydata)
print(loaded_key)