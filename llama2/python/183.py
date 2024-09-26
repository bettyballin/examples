import openssl
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend

# Your secret key in PEM format
secret = 'your_secret_key_here'

# Decode the PEM-encoded private key to DER format
der = openssl.PEM_read_bio(open("secret.pem", "rb").read(), None, None)

# Load the decoded DER data into a PrivateKey object
priv_rsakey = serialization.load_der_private_key(der, password=None, backend=default_backend())