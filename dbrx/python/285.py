import os
from cryptography.fernet import Fernet

# Generate a key and save it into a file
key = Fernet.generate_key()
with open("secret.key", "wb") as secret_file:
    secret_file.write(key)

# Load the saved key from disk
with open("secret.key", "rb") as secret_file:
    key = secret_file.read()

fernet = Fernet(key)
password = b"my_password"
encrypted_password = fernet.encrypt(password)

from instagram import Client

client = Client()
client.login('username', encrypted_password.decode())