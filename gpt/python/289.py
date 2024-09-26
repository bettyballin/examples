
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.serialization import load_pem_public_key
import hashlib

# Load the public key from PEM file
with open('pub_key.pem', 'rb') as key_file:
    public_key = load_pem_public_key(key_file.read(), backend=default_backend())

# Export the public key in DER format using PKCS#1
