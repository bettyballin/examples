import base64
import os
from cryptography.fernet import Fernet

def main():
    # Read the key from the file
    with open('key.txt', 'rb') as f:
        encoded_key = f.read()

    # Decode the key
    key = base64.b64decode(encoded_key)

    # Check the length of the decoded key
    if len(key) != 32:
        raise ValueError('Invalid Fernet key length')

    # Create the encryption object
    ecy = Fernet(key)

if __name__ == "__main__":
    main()