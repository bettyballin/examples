import cryptography
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives import hashes

# Load the public key from a file
with open('client_public.pub', 'rb') as f:
    public_key = serialization.load_pem_public_key(f.read())

# Encrypt the text message
ciphertext = public_key.encrypt(
    b'Hello World!',
    padding.OAEP(
        mgf=padding.MGF1(algorithm=hashes.SHA256()),
        algorithm=hashes.SHA256(),
        label=None
    )
)

# Save the ciphertext to a file
with open('ciphertext.txt', 'wb') as f:
    f.write(ciphertext)