import os
from cryptography.fernet import Fernet

def generate_secret_key():
    return os.urandom(16)

def encrypt(data):
    key = Fernet.generate_key()
    cipher_suite = Fernet(key)
    cipher_text = cipher_suite.encrypt(data)
    return cipher_text

# Generate a secret key if one doesn't exist yet.
if not os.path.exists('secret.key'):
    with open('secret.key', 'wb') as f:
        # Encrypt the generated key before storing it on disk.
        encrypted_key = encrypt(generate_secret_key())
        f.write(encrypted_key)