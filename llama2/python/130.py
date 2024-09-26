import base64
import os
from cryptography.fernet import Fernet
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2

def generate_key(password, salt):
    kdf = PBKDF2(
        algorithm=hashes.SHA256(),
        length=32,
        salt=salt,
        iterations=100000,
        backend=default_backend()
    )
    key = base64.urlsafe_b64encode(kdf.derive(password))
    return key

def encrypt_message(key, message):
    f = Fernet(key)
    token = f.encrypt(message)
    return token

def decrypt_message(key, token):
    f = Fernet(key)
    message = f.decrypt(token)
    return message

if __name__ == "__main__":
    password = "mysecretpassword".encode()
    salt = os.urandom(16)
    key = generate_key(password, salt)

    message = "A really secret message. Not for prying eyes.".encode()
    token = encrypt_message(key, message)

    with open("text_encrypted.txt", "wb") as file:
        file.write(token)

    with open("text_encrypted.txt", "rb") as file:
        token = file.read()

    message = decrypt_message(key, token)

    print(message.decode())