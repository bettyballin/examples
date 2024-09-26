from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.primitives.hashes import SHA256
from cryptography.hazmat.primitives.asymmetric.padding import PSS, MGF1

def generate_keypair():
    key = rsa.generate_private_key(
        public_exponent=65537,
        key_size=2048,
    )
    private_pem = key.private_bytes(
        encoding=serialization.Encoding.PEM,
        format=serialization.PrivateFormat.PKCS8,
        encryption_algorithm=serialization.NoEncryption()
    )
    public_pem = key.public_key().public_bytes(
        encoding=serialization.Encoding.OpenSSH,
        format=serialization.PublicFormat.OpenSSH
    )
    return private_pem, public_pem

def sign_message(private_key, message):
    key = serialization.load_pem_private_key(
        private_key,
        password=None,
    )
    signature = key.sign(
        message,
        PSS(
            mgf=MGF1(hashes.SHA256()),
            salt_length=PSS.MAX_LENGTH
        ),
        hashes.SHA256()
    )
    return signature

def verify_signature(public_key, message, signature):
    key = serialization.load_ssh_public_key(
        public_key,
    )
    key.verify(
        signature,
        message,
        PSS(
            mgf=MGF1(hashes.SHA256()),
            salt_length=PSS.MAX_LENGTH
        ),
        hashes.SHA256()
    )

if __name__ == "__main__":
    private_key, public_key = generate_keypair()
    message = b"Hello, World!"
    signature = sign_message(private_key, message)
    verify_signature(public_key, message, signature)