from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization

with open("path/to/your/file", "rb") as key_file:
    private_key = serialization.load_pem_private_key(
        key_file.read(),
        b"password",  # replace with your password
        backend=default_backend()
    )