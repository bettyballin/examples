import cryptography
from cryptography.fernet import Fernet

key = Fernet.generate_key()
f = Fernet(key)

storage = {}

def encrypt(data):
    encrypted_data = f.encrypt(data.encode("utf-8"))
    return encrypted_data

def decrypt(data):
    decrypted_data = f.decrypt(data)
    return decrypted_data.decode("utf-8")

to_encrypt = "Hello, World!"
storage["encrypted"] = encrypt(to_encrypt)

to_decrypt = storage["encrypted"]

try:
    print("decrypted:", f.decrypt(to_decrypt).decode("utf-8"))
except cryptography.fernet.InvalidToken:
    print("Error decrypting data: invalid token")