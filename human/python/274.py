import os
import hashlib
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.primitives import padding
from cryptography.hazmat.backends import default_backend

plaintext = 'asasasa'
key = hashlib.sha256(os.urandom(60)).digest()[:16]  # use a random key

nonce = os.urandom(12)
iv = nonce + b'\x00\x00\x00\x00'

cipher = Cipher(algorithms.AES(key), modes.CTR(iv), backend=default_backend())
encryptor = cipher.encryptor()

padder = padding.PKCS7(128).padder()
padded_data = padder.update(plaintext.encode()) + padder.finalize()

ciphertext = encryptor.update(padded_data) + encryptor.finalize()

print(nonce.hex() + ciphertext.hex())