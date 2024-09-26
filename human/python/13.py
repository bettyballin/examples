from Crypto.Cipher import AES
import os

secret = os.urandom(16)
crypto = AES.new(os.urandom(32), AES.MODE_CTR, counter=lambda: secret)
encrypted = crypto.encrypt("aaaaaaaaaaaaaaaa")
print(crypto.decrypt(encrypted))