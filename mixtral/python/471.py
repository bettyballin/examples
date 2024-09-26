from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from cryptography.hazmat.backends import default_backend
import base64
from Crypto.Cipher import AES

def enc(a):
    password = base64.b64decode('lrvq/wyDf6tqhxvg8NuIDQ==')

    salt = 'Ivan Medvedev'.encode()

    kdf = PBKDF2HMAC(
        algorithm=hashes.SHA1(),
        length=32,
        salt=salt,
        iterations=1000,
        backend=default_backend())

    key = base64.b64encode(kdf.derive(password))

    # take first 32 bytes as key
    key = key[:32]

    iv = kdf.derive(password)[-16:]

    data = a.encode('utf_16le')

    cipher = AES.new(key, AES.MODE_CBC, IV=iv)
    return cipher.encrypt(data)

# Example usage:
encrypted_data = enc("Hello, World!")
print(encrypted_data)