
# On the receiver's side
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend

public_key = serialization.load_pem_public_key(
    public_bytes,
    backend=default_backend()
)

