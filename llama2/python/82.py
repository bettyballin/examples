import cryptography
from cryptography.fernet import Fernet
import base64
import os

# Generate a random key
key = Fernet.generate_key()

# Encrypt the plaintext
plaintext = b'This is a secret message.'
ciphertext = Fernet(key).encrypt(plaintext)

print(ciphertext.decode())