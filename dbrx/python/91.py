from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa

pubK = "your_public_key_here"  # Replace with your actual public key
public_key = serialization.load_pem_public_key(pubK.encode())