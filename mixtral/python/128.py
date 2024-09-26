from Cryptodome.PublicKey import RSA
from Cryptodome.Cipher import PKCS1_OAEP

key = RSA.import_key(open("private.pem", "rb").read())
cipher = PKCS1_OAEP.new(key)
binary_data = open("encrypted_data.bin", "rb").read()  # assuming you have encrypted data in a file
message = cipher.decrypt(binary_data)
print(message.decode())