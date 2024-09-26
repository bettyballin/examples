import os
import base64
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC

def derive_key(password, salt):
    password = password.encode()

    kdf = PBKDF2HMAC(
        algorithm=hashes.SHA256(),
        length=32,
        salt=salt,
        iterations=100000
    )

    return base64.urlsafe_b64encode(kdf.derive(password))

def generate_aes_key():
    key = os.urandom(32)
    salt = os.urandom(16)
    derived_key = derive_key("userA's password", salt).decode()
    return (
        base64.urlsafe_b64encode(key),
        base64.urlsafe_b64encode(salt),
        derived_key
    )

print(generate_aes_key())