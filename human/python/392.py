import os
from cryptography.fernet import Fernet

# Generate a key
key = Fernet.generate_key()
cipher_suite = Fernet(key)

# Create a list of byte-strings
listAll = [cipher_suite.encrypt(b'Hello'), cipher_suite.encrypt(b'World')]

with open('.\\TEST\\text_encrypt.txt', 'wb') as pt:
    to_write = b'\n'.join(listAll)
    pt.write(to_write)

with open('.\\TEST\\text_encrypt.txt', 'rb') as fh:
    contents = fh.read()

ciphers = contents.split(b'\n')

for cipher in ciphers:
    if cipher:
        print(cipher_suite.decrypt(cipher))