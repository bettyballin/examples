from Crypto.Cipher import AES
import base64
import hashlib

def pad(s):
    return s + b"\0" * (AES.block_size - len(s) % AES.block_size)

text = "data".encode('utf-8')
password = "key".encode()

cipher = AES.new(hashlib.md5(password).digest(), AES.MODE_ECB)
ct_bytes = cipher.encrypt(pad(text))

# encode to base64
encoded_msg = base64.b64encode(ct_bytes)

print('Encoded msg:', encoded_msg)