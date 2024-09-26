import os
from cryptography.fernet import Fernet

if __name__ == "__main__":
    key = Fernet.generate_key()
    cipher_suite = Fernet(key)
    print(cipher_suite)