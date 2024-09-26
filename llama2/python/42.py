import base64
import hashlib

def sha256_hash(data):
    return base64.b64encode(hashlib.sha256(data).digest()).decode()

secret = b'my_secret_key'
auth_token = b'my_auth_token'
timestamp = 1234567890

first = sha256_hash(secret + auth_token)
second = sha256_hash(str(timestamp).encode() + secret)

print(first)
print(second)