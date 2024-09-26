import os
import binascii
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.primitives import padding
from cryptography.hazmat.backends import default_backend

key = binascii.hexlify(os.urandom(32)).decode('utf-8')
ctr_value = int(binascii.hexlify(os.urandom(16)), 16)

# Create the counter and AES object
cipher = Cipher(algorithms.AES(key.encode('utf-8')), modes.CTR(ctr_value.to_bytes(16, 'big')), backend=default_backend())
obj = cipher.encryptor()