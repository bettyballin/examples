from Crypto.Cipher import AES
from Crypto.Hash import SHA256
from Crypto.Util.Padding import pad
import base64

def enc(a):
    password = b'lrvq/wyDf6tqhxvg8NuIDQ=='
    salt = b'Ivan Medvedev'
    iterations = 1000

    key_bytes = SHA256.new(password + salt).digest()
    for _ in range(iterations - 1):
        key_bytes = SHA256.new(key_bytes + salt).digest()

    key = key_bytes[:32]
    iv = key_bytes[32:48]

    data = a.encode('utf-16le')
    data = pad(data, AES.block_size)

    cipher = AES.new(key, AES.MODE_CBC, iv)
    encrypted = cipher.encrypt(data)

    print(base64.b64encode(encrypted).decode())

enc("Cat")