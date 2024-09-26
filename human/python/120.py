import hashlib
from Crypto.Cipher import AES

DUMMY_IV = b'\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00'
aes_key = bytes.fromhex('26333B482869778C14A2BEC1D4E2FD14')
aes = AES.new(aes_key, AES.MODE_ECB)

data = aes.decrypt(bytes.fromhex('5cc4711e67703657f0a04d887d7c074e'))
print(data.decode())