from base64 import b64decode
import os

from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes

data = 'base 64 encoded encrypted data'
password = b'password'
salt = bytes('XB7sHH26Hn&FmPLxnjGccKTfPV(yk', encoding='utf-8')

kdf = PBKDF2HMAC(
    algorithm=hashes.SHA1(),
    length=32,  # AES key size is always 32 bytes
    salt=salt,
    iterations=100_000,
    backend=default_backend()
)

psw = kdf.derive(password + b'tXntTbJFzh]4EuQVmjzM9GXHCth8')

iv = os.urandom(16)  # Crypto-js uses random IV by default

cipher_suite = algorithms.AES(psw[:32])
mode_of_operation = modes.CBC(iv=iv)

decryptor = Cipher(
    cipher_suite,
    mode_of_operation
).decryptor()

res = decryptor.update(b64decode(data)) + decryptor.finalize()

print(res)