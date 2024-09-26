
import os
from Crypto.Cipher import AES
from Crypto.Hash import SHA256
from Crypto import Random

'''Encryption'''

k = 'mykey'
hasher = SHA256.new(k.encode('utf-8'))
k = hasher.digest()

p = 'enigmaticaura'
print(p)

def pad(s):
    return s + b" " * (AES.block_size - len(s) % AES.block_size)

def encrypt(message, key, iv):
