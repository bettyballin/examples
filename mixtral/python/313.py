from cryptography.fernet import Fernet
import base64
import hashlib

def generate_key(password):
    hashed_password = hashlib.sha256(password.encode()).digest()
    return base64.urlsafe_b64encode(hashed_password)

password = "your_password"
data = b"encrypted_data"

try:
    key = generate_key(password)
    cipher_suite = Fernet(key)
    token = cipher_suite.decrypt(data)
except Exception as e:
    print("wow")