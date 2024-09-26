
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa

# Replace 'your_passphrase' with the passphrase used to encrypt your private key
passphrase = b'your_passphrase'

# Load your encrypted key
with open('path_to_encrypted_key.pem', 'rb') as key_file:
    encrypted_key = key_file.read()

# First, we'll load the encrypted key using the password
private_key = serialization.load_pem_private_key(
    encrypted_key,
    password=passphrase,
    backend=default_backend()
)

# Now we have the key as a private_key object, we can convert it to the RSA format
rsa_private_key = private_key.private_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PrivateFormat.TraditionalOpenSSL,
   
