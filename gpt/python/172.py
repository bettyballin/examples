
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization

# Replace this with the path to your private key file
private_key_path = '/path/to/private_key.pem'

# Load the private key from the file
with open(private_key_path, 'rb') as key_file:
    private_key_data = key_file.read()
    private_key = serialization.load_pem_private_key(
        private_key_data,
       
