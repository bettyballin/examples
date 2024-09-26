from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import padding
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
import base64

def _derive_key(password, salt):
    password = password.encode()
    kdf = PBKDF2HMAC(
        algorithm=hashes.MD5(),
        length=16,
        salt=salt,
        iterations=100000,
        backend=default_backend()
    )

    return base64.urlsafe_b64encode(kdf.derive(password))

def _encrypt(message, password, salt):
    key = _derive_key(password, salt)

    cipher = Cipher(algorithms.TripleDES(key), modes.CBC(b'\0' * 8), backend=default_backend())

    encryptor = cipher.encryptor()

    padder = padding.PKCS7(64).padder()

    padded_message = padder.update(message) + padder.finalize()

    return base64.urlsafe_b64encode(encryptor.update(padded_message) + encryptor.finalize())

# Example usage:
password = "mysecretpassword"
salt = b"mysalt"
message = b"Hello, World!"

print(_encrypt(message, password, salt))