
from cryptography.fernet import Fernet

# You should load the key from an environment variable or secure storage
encryption_key = Fernet.generate_key()  # For demo purposes, generate a new key
cipher_suite = Fernet(encryption_key)

def encrypt_text(text):
    if not text:
        return None
