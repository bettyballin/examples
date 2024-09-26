from cryptography.fernet import Fernet
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
import base64
import os

# Set password and salt
psw = b"mysecretpassword"
salt = os.urandom(16)

# Create a PBKDF2 hash
kdf = PBKDF2HMAC(
    algorithm=hashes.SHA256(),
    length=32,
    salt=salt,
    iterations=100000,
)

# Derive the encryption key
key = base64.urlsafe_b64encode(kdf.derive(psw))

# Create a Fernet instance with the derived key
fernet = Fernet(key)

print(fernet)