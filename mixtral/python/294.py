import os
import base64
import hashlib

def sha512_crypt(password, salt):
    hashed = hashlib.sha512((salt + password).encode()).digest()

    # Convert the binary digest to a string
    encoded = base64.b64encode(hashed)

    return '$6$' + salt + '$' + encoded.decode('ascii')

# Example usage:
salt = os.urandom(16).hex()
password_hash = sha512_crypt('my-secret', salt)
print("SALT:", salt)
print("HASH:", password_hash)