from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa

with open("public_key.pem", "rb") as f:
    public_key = serialization.load_pem_public_key(f.read())