from cryptography.fernet import Fernet
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives import padding
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend
import os

# Generate a random secret key for symmetric encryption
secret_key = Fernet.generate_key()

# Encrypt the file contents using AES-GCM with the secret key
cipher_suite = Fernet(secret_key)
encrypted_data = cipher_suite.encrypt(b"Hello World!")

# Generate a pair of keys for public-key encryption
private_key = rsa.generate_private_key(
    public_exponent=65537,
    key_size=3072,
    backend=default_backend()
)
public_key = private_key.public_key()

# Encrypt the secret key using user B's public key
encrypted_secret_key = public_key.encrypt(
    secret_key,
    padding.OAEP(
        mgf=padding.MGF1(algorithm=hashes.SHA256()),
        algorithm=hashes.SHA256(),
        label=None
    )
)

print("Encrypted Data:", encrypted_data)
print("Encrypted Secret Key:", encrypted_secret_key)