from cryptography.fernet import Fernet
import base64
import hashlib

plaintext = 'Attack at dawn!!'
password = 'yellow submarine'

key = base64.urlsafe_b64encode(hashlib.sha256(password.encode()).digest())
cipher = Fernet(key)

cipher_text = cipher.encrypt(plaintext.encode())

print(cipher_text.decode())