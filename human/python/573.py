from cryptography.hazmat.primitives import serialization, hashes
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.backends import default_backend

# Assuming you have a private key in a file named 'private_key.pem'
with open('private_key.pem', 'rb') as key_file:
    private_key = serialization.load_pem_private_key(
        key_file.read(),
        password=None,
        backend=default_backend()
    )

plain_text = b'Your plain text here'

signature = private_key.sign(
    data=plain_text,
    padding=padding.PKCS1v15(),
    algorithm=hashes.SHA256()
)

print(signature)