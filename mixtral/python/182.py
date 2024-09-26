from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization

with open("key.pem", "rb") as f:
    encrypted_private_key = f.read()

password = b"passphrase"
private_key = serialization.load_pem_private_key(
    encrypted_private_key,
    password=password,
    backend=default_backend()
)