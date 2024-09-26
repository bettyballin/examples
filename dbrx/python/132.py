from itertools import product
import Crypto.Cipher.AES

def hex_to_bytes(hex_string):
    return bytearray.fromhex(hex_string)

key = hex_to_bytes('2b7e151628aed2a6abf7158809cf4f3c')
IV = hex_to_bytes('000102030405060708090a0b0c0d0e0f')

plaintext1 = hex_to_bytes('6bc1bee22e409f96e93d7e117393172a')
plaintext2 = hex_to_bytes('ae2d8a571e03ac9c9eb76fac45af8e51')
plaintext3 = hex_to_bytes('30c81c46a35ce411e5fbc1191a0a52ef')

cipher = Crypto.Cipher.AES.new(key, Crypto.Cipher.AES.MODE_CBC, IV)
ciphertext = cipher.encrypt(plaintext1 + plaintext2 + plaintext3)

decipher = Crypto.Cipher.AES.new(key, Crypto.Cipher.AES.MODE_CBC, IV)
plaintext_decrypted = decipher.decrypt(ciphertext)

print(f"Decrypted text (hex): {plaintext_decrypted.hex()}")