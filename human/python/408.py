import base64
import hmac
import hashlib
import time
import os

def generate_token(ciphertext, secret_key):
    version = b"1"
    timestamp = int(time.time()).to_bytes(8, byteorder='big')
    iv = os.urandom(16)
    hmac_value = hmac.new(secret_key, iv + ciphertext, hashlib.sha256).digest()
    token = base64.urlsafe_b64encode(version + timestamp + iv + ciphertext + hmac_value)
    return token

# usage
secret_key = b"your_secret_key"
ciphertext = b"your_ciphertext"
token = generate_token(ciphertext, secret_key)
print(token)