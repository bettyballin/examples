from Crypto.Cipher import AES
import os

BLOCK_SIZE = 32
PADDING = b'0'

pad = lambda s: s + (BLOCK_SIZE - len(s) % BLOCK_SIZE) * PADDING

EncodeAES = lambda c, s: c.encrypt(pad(s))
DecodeAES = lambda c, e: c.decrypt(e).rstrip(PADDING).decode('utf-8')

secret = 'ककककक..'.encode()
obj = AES.new(secret, AES.MODE_ECB)

message = 'कककककककककककक'.encode()
encoded = EncodeAES(obj, message)
decoded = DecodeAES(obj, encoded)
print('Decrypted string:', decoded)