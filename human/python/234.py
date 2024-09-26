from Crypto.PublicKey import RSA
from Crypto.Signature import PKCS1_v1_5
from base64 import b64decode

rsa_key = RSA.importKey(open('private.txt', "rb").read())
cipher = PKCS1_v1_5.new(rsa_key)
raw_cipher_data = b64decode(input("Enter your cipher data: "))
phn = cipher.verify(raw_cipher_data, b"some default")
print(phn)