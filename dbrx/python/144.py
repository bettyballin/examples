from Crypto.Cipher import AES
from base64 import b64encode

def pkcs5_pad(data):
    length = 16 - len(data) % 16
    return data + bytes([length]) * length

plaintext = 'Attack at dawn!!'
padded_plaintext = pkcs5_pad(plaintext.encode())

obj = AES.new(b"yellow submarine", AES.MODE_ECB)
ciphertext = obj.encrypt(padded_plaintext)

print(b64encode(ciphertext).decode())