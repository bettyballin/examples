import cryptography
from cryptography.hazmat import serialization

with open("keyshare_kotlin", "rb") as f:
     keyshare_kotlin = f.read()

loaded_public_key = serialization.load_der_public_key(
    data=keyshare_kotlin,
    backend=cryptography.hazmat.backends.default_backend()
)