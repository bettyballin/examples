import hashlib
from Crypto.Random import Random
from Crypto.Cipher import AES
from base64 import b64encode

key = hashlib.md5(b"lazydog").digest()
while len(key) < 32:
    key += b'\0'

iv = Random.new().read(AES.block_size)
cipher = AES.new(key, AES.MODE_CBC, iv)
msg = cipher.encrypt("Attack at dawn".encode())

print(b64encode(iv + msg).decode('utf-8'))