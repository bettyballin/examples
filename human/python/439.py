from Crypto.Cipher import AES
from Crypto.Hash import SHA256
from Crypto.Util.Padding import pad
import base64
import hashlib

password = b"lazydog"
salt = b"salt"
iterations = 128

key = hashlib.pbkdf2_hmac('sha256', password, salt, iterations, 48)

iv = key[:16]
key = key[16:]

cipher = AES.new(key, AES.MODE_CBC, iv)
ciphertext = cipher.encrypt(pad(b"Attack at dawn", AES.block_size))

print(base64.b64encode(ciphertext).decode())