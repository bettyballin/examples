from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa

priK = "your_private_key_here"  # replace with your private key in PEM format
private_key = serialization.load_pem_private_key(
    priK.encode(),
    password=None,
)
public_key = private_key.public_key()