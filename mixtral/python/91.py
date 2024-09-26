from Crypto.Cipher import Blowfish
import binascii

# Convert hexadecimal to bytes
cipher_hex = 'your_encrypted'
iv_hex     = 'your_IV'

cipher    = binascii.unhexlify(cipher_hex)
initialization_vector  = binascii.unhexlify(iv_hex)

# Decryption
key       = b"your_secret"
decryptor = Blowfish.new(key, mode=Blowfish.MODE_CBC, iv=initialization_vector)
plaintext = decryptor.decrypt(cipher).decode('utf-8')

print("Decrypted:", plaintext)