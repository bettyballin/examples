from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization

with open("path/to/your/private_key.pem", "rb") as f:
    private_key = serialization.load_pem_private_key(
        f.read(),
        password=None,
        backend=default_backend()
    )