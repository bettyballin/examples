from cryptography.fernet import Fernet
import base64
import hashlib

password = "your_password_here"
data = "your_encrypted_data_here"

key = base64.urlsafe_b64encode(hashlib.sha256(password.encode()).digest())

try:
    f = Fernet(key)
    data_decrypted = f.decrypt(data.encode())
    print(data_decrypted.decode())
except (Fernet.InvalidToken, ValueError):
    print("Invalid token or decryption error")