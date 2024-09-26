import base64
from Crypto.PublicKey import RSA

key = RSA.importKey(open('path/to/your/private/key', 'rb').read())

encrypted_string = 'your_encrypted_string_here'
ciphertext = base64.b64decode(encrypted_string)

plaintext = key.decrypt(ciphertext)

print(plaintext)