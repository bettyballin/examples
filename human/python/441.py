from base64 import b64decode
from Crypto.Cipher import AES
from Crypto.Protocol.KDF import PBKDF2 

data = b64decode("ibirgCQu8TwtJOaKKtMLxw==")

bytes = PBKDF2("lazydog".encode("utf-8"), "salt".encode("utf-8"), 48, 128)
iv = bytes[0:16]
key = bytes[16:48]
cipher = AES.new(key, AES.MODE_CBC, iv)
text = cipher.decrypt(data)
text = text[:-text[-1]].decode("utf-8")

print(text)