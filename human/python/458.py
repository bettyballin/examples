from cryptography.fernet import Fernet
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
import base64
import os

password = b"mysecretpassword"
salt = os.urandom(16)
kdf = PBKDF2HMAC(
    algorithm=hashes.SHA256(),
    length=32,
    salt=salt,
    iterations=100000,
)
key = base64.urlsafe_b64encode(kdf.derive(password))

data = b"encrypted_data_here"

try:
    f = Fernet(key)
    token = f.decrypt(data)
except (Fernet.InvalidToken, TypeError):
    print("wow")