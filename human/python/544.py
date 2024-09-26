from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization

pkcs8Encrypted = b"""-----BEGIN ENCRYPTED PRIVATE KEY-----
MIICzzBJB...
-----END ENCRYPTED PRIVATE KEY-----"""

privateKey = serialization.load_pem_private_key(
    pkcs8Encrypted, 
    b'mypassword',
    default_backend()
)

if __name__ == "__main__":
    try:
        print(privateKey)
    except Exception as e:
        print(f"An error occurred: {e}")