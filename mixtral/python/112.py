from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend

private_key = serialization.load_pem_private_key(
    data=bytes(prvK, 'utf-8'),
    password=None,
    backend=default_backend()
)

# You can also load the private key from a file
with open("path/to/your/file.pem", "rb") as f:
    pk = serialization.load_pem_private_key(
        f.read(),
        password=None,
        backend=default_backend()
    )