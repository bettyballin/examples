import os
import tempfile
from cryptography.fernet import Fernet

def encrypt(filename, key):
    f = Fernet(key)

    with open(filename, "rb") as file:
        file_data = file.read()

    encrypted_data = f.encrypt(file_data)

    # Create a temporary directory
    tempdir = tempfile.TemporaryDirectory()

    # Save the encrypted data to this new location
    with open(os.path.join(tempdir.name, filename), "wb") as file:
        file.write(encrypted_data)

    return os.path.abspath(os.path.join(tempdir.name, filename))