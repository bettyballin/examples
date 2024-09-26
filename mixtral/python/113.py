from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization

pubK = "your_public_key_here"
public_key = serialization.load_pem_public_key(
    data=bytes(pubK, 'utf-8'),
    backend=default_backend()
)

# You can also load the private key from a file
with open("path/to/your/file.pem", "rb") as f:
  pk = serialization.load_pem_public_key(f.read(), backend=default_backend())