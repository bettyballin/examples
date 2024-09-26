import os
from cryptography.fernet import Fernet

# Generate a secure key
key = Fernet.generate_key()

# Create a Fernet encryptor
encryptor = Fernet(key)

# Encrypt the plaintext
ciphertext = encryptor.encrypt("Hello World!".encode())

# Decrypt the ciphertext
plaintext = encryptor.decrypt(ciphertext)

print(plaintext.decode())