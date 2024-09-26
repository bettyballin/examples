
from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP
import os

def encrypt(file, public_key):
    cipher = PKCS1_OAEP.new(public_key)
    with open(file, 'rb') as original_file
