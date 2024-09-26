import os
from cryptography.fernet import Fernet

def load_key():
    with open('key.key', 'rb') as key_file:
        return key_file.read()

key = load_key()
fer = Fernet(key)

def encrypt_files(path):
    for file in os.listdir(path):
        if not file.startswith('.'):
            full_path = os.path.join(path, file)
            if os.path.isfile(full_path):
                with open(full_path, 'rb') as f:
                    data = fer.encrypt(f.read())
                with open(full_path, 'wb') as f:
                    f.write(data)
            elif os.path.isdir(full_path):
                encrypt_files(full_path)

encrypt_files(r"C:\Users\{}\encrypt_test".format(os.getlogin()))