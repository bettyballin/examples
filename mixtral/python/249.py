from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.backends import default_backend

PUBLIC_EXPONENT = 65537
KEY_SIZE = 2048

def generate_rsa_private_key():
    return rsa.generate_private_key(
        public_exponent=PUBLIC_EXPONENT,
        key_size=KEY_SIZE,
        backend=default_backend()
    )

# Generate a new RSA private key
new_rsa_private_key = generate_rsa_private_key()

# Print the new RSA private key
print(new_rsa_private_key.private_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PrivateFormat.PKCS8,
    encryption_algorithm=serialization.NoEncryption()
))