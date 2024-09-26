from hashlib import md5
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad
import time

password = "your_password_here"
timestamp = str(int(time.time())).encode()

last = ''
bytes = ''

# 32 byte key (256 bits) + 16 byte IV = 48 bytes needed
while len(bytes) < 48:
    last = md5((last + password.encode()).digest())
    bytes += last

key = bytes[0:32]
iv = bytes[32:48]

aes = AES.new(key, AES.MODE_CBC, iv)
ciphertext = aes.encrypt(pad(timestamp))

print(ciphertext.hex())