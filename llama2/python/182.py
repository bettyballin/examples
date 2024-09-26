from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend

secret = "your_secret_key_here"
priv_rsakey = serialization.load_pem_private_key(
    secret.encode('utf-8'),
    password=None,
    backend=default_backend()
)