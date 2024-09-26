from Crypto.Protocol.KDF import PBKDF2
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad
import base64

def enc(a):
    keyIv = PBKDF2(b'lrvq/wyDf6tqhxvg8NuIDQ==', b'Ivan Medvedev', dkLen=48, count=1000)
    key = keyIv[:32]
    iv = keyIv[32:]
    data = a.encode('utf-16le')
    
    cipher = AES.new(key, AES.MODE_CBC, iv)
    encrypted = cipher.encrypt(pad(data, AES.block_size))
    
    return base64.b64encode(encrypted).decode('utf-8')

print(enc("Cat"))  # CZ/1nUYEjhw4cFj08Yt1EQ==