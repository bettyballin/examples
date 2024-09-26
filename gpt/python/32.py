
from cryptography.fernet import Fernet

# Generate a key based on your shared secret. In practice, you'll want to use a key derivation function.
def generate_key(shared_private_key):
    return Fernet.generate_key()

# Encrypt a message with the key
def encrypt_message(message, key):
    f =
