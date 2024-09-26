from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP
import binascii

pubKey = RSA.import_key(open("public_key.pem").read())

with open("plaintext.txt", "rb") as file:
    f = file.read()

encryptor = PKCS1_OAEP.new(pubKey)
encrypted = encryptor.encrypt(f)

print("Encrypted:", binascii.hexlify(encrypted))