import base64
import os

def b32_encode_no_padding(data):
    return base64.b32encode(data).decode('utf-8').rstrip('=')

secret = os.urandom(16)
encoded_secret = b32_encode_no_padding(secret)
print(encoded_secret)