from binascii import Error
from cryptography.fernet import Fernet
import base64
import hashlib

password = b"your_password_here"
data = b"your_encrypted_data_here"

key = base64.urlsafe_b64encode(hashlib.sha256(password).digest())

try:
    f = Fernet(key)
    token = f.decrypt(data)
except (Fernet.InvalidToken, TypeError, Error):
    print("wow")