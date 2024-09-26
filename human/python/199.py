import hashlib
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.primitives import padding
from cryptography.hazmat.backends import default_backend

algorithm = algorithms.AES(b'00000000000000000000000000000000')
iv = b'0000000000000000'
text = 'this-needs-to-be-encrypted'

cipher = Cipher(algorithm, modes.CBC(iv), backend=default_backend())
encryptor = cipher.encryptor()
padder = padding.PKCS7(128).padder()
padded_data = padder.update(text.encode('utf-8')) + padder.finalize()
encrypted = encryptor.update(padded_data) + encryptor.finalize()
print('encrypted', encrypted.hex(), len(encrypted.hex()))