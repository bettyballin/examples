
from Crypto.Cipher import AES
import binascii

key = bytes.fromhex('2b7e151628aed2a6abf7158809cf4f3c')
IV = bytes.fromhex('000102030405060708090a0b0c0d0e0f')
plaintext1 = bytes.fromhex('6bc1bee22e409f96e93d7e117393172a')
plaintext2 = bytes.fromhex('ae2d8a571e03ac9c9eb76fac45af8e51')
plaintext3 = bytes.fromhex('30c81c46a35ce411e5fbc1191a0a52ef')

cipher = AES.new(key, AES.MODE_CBC, IV)
ciphertext = cipher.encrypt(plaintext1 + plaintext2 + plaintext3
