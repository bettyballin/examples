from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.backends import default_backend

remote_public_bytes = b'your_remote_public_key_bytes_here'
public_key = serialization.load_pem_public_key(
    remote_public_bytes,
    backend=default_backend()
)