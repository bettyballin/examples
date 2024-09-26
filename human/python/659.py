import base64
import hashlib

def bytesToKey(salt, key):
    keyBytes = hashlib.pbkdf2_hmac('sha256', key.encode('utf-8'), salt, 100000)
    ivBytes = hashlib.pbkdf2_hmac('sha256', keyBytes, salt, 100000)
    return keyBytes + ivBytes[:16]

data = "your_base64_encoded_data_here"
key = "your_key_here"

encrypted = base64.b64decode(data)
salt = encrypted[8:16]
ciphertext = encrypted[16:]
keyIv = bytesToKey(salt, key)
key = keyIv[:32]
iv = keyIv[32:]