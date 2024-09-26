import os
from cryptography.fernet import Fernet

# Generate a new encryption/decryption key
key = Fernet.generate_key()

# Create an instance of Fernet with this generated key
cipher_suite = Fernet(key)

# Define the password to be encrypted
passwd = input("Enter a password: ")

# Encrypt the password
encrypted_password = cipher_suite.encrypt(passwd.encode('utf-8'))

print("Generated Key:", key)
print("Encrypted Password:", encrypted_password)