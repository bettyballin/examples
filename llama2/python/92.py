from itertools import product
from Crypto.Cipher import AES

key = bytes.fromhex('2b7e151628aed2a6abf7158809cf4f3c')
IV = bytes.fromhex('30c81c46a35ce411e5fbc1191a0a52ef')

plaintext1 = bytes.fromhex('30c81c46a35ce411e5fbc1191a0a52ef')
plaintext2 = bytes.fromhex('30c81c46a35ce411e5fbc1191a0a52ef')
plaintext3 = bytes.fromhex('30c81c46a35ce411e5fbc1191a0a52ef')

cipher = AES.new(key, AES.MODE_CBC, IV)
ciphertext = cipher.encrypt(plaintext1 + plaintext2 + plaintext3)

decipher = AES.new(key, AES.MODE_CBC, IV)
plaintext = decipher.decrypt(ciphertext)

print(plaintext.hex())