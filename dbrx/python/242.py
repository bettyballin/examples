import os
import json
from base64 import b64encode, b64decode
from Crypto.Cipher import AES
from Crypto.Random import urandom
from Crypto.Util.Padding import pad, unpad

# Generate a random 256-bit key (32 bytes)
key = urandom(32)

# Data to encrypt
your_data = {"name": "John", "age": 30}

# Encrypt the data using CBC mode with PKCS7 padding
cipher = AES.new(key, AES.MODE_CBC)
plaintext = json.dumps(your_data).encode('utf-8')
ciphertext = cipher.encrypt(pad(plaintext))

# Encode ciphertext as base64 for storage or transmission
encrypted_base64 = b64encode(cipher.iv + ciphertext)

# To decrypt:
decrypted_base64 = b64decode(encrypted_base64)
iv = decrypted_base64[:AES.block_size]
encrypted = decrypted_base64[AES.block_size:]
cipher = AES.new(key, AES.MODE_CBC, iv=iv)
plaintext_padded = cipher.decrypt(encrypted)
plaintext_unpadded = unpad(plaintext_padded)

# Convert the plaintext back to JSON
decrypted_data = json.loads(plaintext_unpadded.decode('utf-8'))

print("Decrypted data:", decrypted_data)