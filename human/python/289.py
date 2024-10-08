from Crypto.Cipher import AES
from binascii import hexlify, unhexlify

key = unhexlify('2b7e151628aed2a6abf7158809cf4f3c')
IV = unhexlify('000102030405060708090a0b0c0d0e0f')
plaintext1 = unhexlify('6bc1bee22e409f96e93d7e117393172a')
plaintext2 = unhexlify('ae2d8a571e03ac9c9eb76fac45af8e51')
plaintext3 = unhexlify('30c81c46a35ce411e5fbc1191a0a52ef')

cipher = AES.new(key, AES.MODE_CBC, IV)
ciphertext = cipher.encrypt(plaintext1 + plaintext2 + plaintext3)

print(hexlify(ciphertext))

decipher = AES.new(key, AES.MODE_CBC, IV)
plaintext = decipher.decrypt(ciphertext)

print(plaintext == plaintext1 + plaintext2 + plaintext3)
print(hexlify(plaintext))