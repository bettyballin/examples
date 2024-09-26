from Crypto.Protocol.KDF import PBKDF2
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad

def enc(a):
    key = PBKDF2(b"lrvq/wyDf6tqhxvg8NuIDQ==", b"Ivan Medvedev", dkLen=32, count=1000)
    iv = key[:16]
    data = a.encode('utf-16le')

    cipher = AES.new(key, AES.MODE_CBC, iv)
    encrypted = cipher.encrypt(pad(data, AES.block_size))

    return encrypted.hex()

print(enc("Cat"))