
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives.serialization import load_pem_private_key
from cryptography.hazmat.backends import default_backend
import json

# Load the private key from a file
private_key_pem = "/etc/ssl/nginx/snbcsr.key"
with open(private_key_pem, "rb") as key_file:
    private_key = load_pem_private_key(key_file.read
