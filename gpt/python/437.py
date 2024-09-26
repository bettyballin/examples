
from cryptography.fernet import Fernet
import os

def load_key():
    with open('key.key', 'rb') as key_file:
        return key_file.read()

def encrypt_file(file_path, fernet):
    with open(file_path, 'rb') as file:
        original = file.read()
    encrypted = fernet.encrypt(original)
    with open(file_path, 'wb') as file:
        file.write(encrypted)

def encrypt_directory(path, fernet):
    for root, dirs, files in os.walk(path):
        for file in files:
            file_path = os.path.join(root, file)
            encrypt_file(file_path, fernet)
            print(f'Encrypted: {file_path}')

# Generate a key if there isn't one already (uncomment if needed)
# key = Fernet.generate_key()
# with
