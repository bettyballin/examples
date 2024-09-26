from Crypto.Cipher import AES
from base64 import b64encode

plaintext = 'Attack at dawn!!'
key = "yellow submarine".encode()
obj = AES.new(key, AES.MODE_ECB)
plaintext = plaintext.encode()
while len(plaintext) % 16 != 0:
    plaintext += b'\x00'
ciphertext = obj.encrypt(plaintext)

print(b64encode(ciphertext).decode())