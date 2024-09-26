from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import ec

# Load private key
with open("private_key.pem", "rb") as f:
    server_private_key = serialization.load_pem_private_key(
        data=f.read(),
        password=None,
        backend=default_backend()
    )

# Load public key
with open("public_key.pub", "rb") as f:
    client_public_key = serialization.load_pem_public_key(
        data=f.read(),
        backend=default_backend()
    )

shared_secret = server_private_key.exchange(ec.ECDH(), client_public_key)