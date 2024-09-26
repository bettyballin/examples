from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.backends import default_backend

KEY_SIZE = 2048
PUBLIC_EXPONENT = 65537

def generate_keypair():
    key = rsa.generate_private_key(
        public_exponent=PUBLIC_EXPONENT,
        key_size=KEY_SIZE,
        backend=default_backend()
    )
    private_key = key.private_bytes(
        encoding=serialization.Encoding.PEM,
        format=serialization.PrivateFormat.PKCS8,
        encryption_algorithm=serialization.NoEncryption()
    )
    public_key = key.public_key().public_bytes(
        encoding=serialization.Encoding.OpenSSH,
        format=serialization.PublicFormat.OpenSSH
    )
    return private_key, public_key

if __name__ == "__main__":
    private_key, public_key = generate_keypair()
    print("Private Key:")
    print(private_key.decode("utf-8"))
    print("Public Key:")
    print(public_key.decode("utf-8"))