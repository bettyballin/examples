from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP
import binascii

# Load the public key
with open("public_key.pem", "r") as f:
    pub_key = RSA.import_key(f.read())

# Encrypt the message
msg = b"A message for encryption"
encryptor = PKCS1_OAEP.new(pub_key)
encrypted = encryptor.encrypt(msg)
print("Encrypted:", binascii.hexlify(encrypted))

# Decrypt the ciphertext
with open("private_key.pem", "r") as f:
    priv_key = RSA.import_key(f.read())

decryptor = PKCS1_OAEP.new(priv_key)
ciphertext = binascii.unhexlify(binascii.hexlify(encrypted))
decrypted = decryptor.decrypt(ciphertext)
print("Decrypted:", decrypted)