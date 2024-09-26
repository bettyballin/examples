from binascii import hexlify

ciphertext = b'your ciphertext here'
ciphertext_hex = hexlify(ciphertext)
print(ciphertext_hex)

plaintext = b'your plaintext here'
plaintext_hex = hexlify(plaintext)
print(plaintext_hex)