import binascii
from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP

# Assuming pubKey is an RSA public key
pubKey = RSA.import_key(open("public_key.pem").read())

f = open("plaintext.txt", "r")
content_str = f.read()
f.close()

content_bytes = content_str.encode('utf-8')
encryptoor = PKCS1_OAEP.new(pubKey)
encrypted = encryptoor.encrypt(content_bytes)
print("Encrypted:", binascii.hexlify(encrypted))