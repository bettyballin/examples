
from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_v1_5
import base64
import sys

def decode_rsa(encryptedString, key_path):
    with open(key_path, 'rb') as key_file:
        key = RSA.importKey(key_file.read())
    
    decodedString = base64.b64decode(encryptedString)
    
    # Create a cipher object and use it to decrypt the data
    cipher = PKCS1_v1_5.new(key)
    decryptedString = cipher.decrypt(decodedString, None)
    
    # Remove PKCS#1 v1.5 padding manually if
