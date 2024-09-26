import time
from os import urandom
from base64 import b64encode
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad

key = b'1Lw2*kx18#AvNuij*iRL1nY1UA_#k8$+'
timestamp = b"1489355323"

BS = 16
iv = urandom(BS)

aes = AES.new(key, AES.MODE_CBC, iv)
ciphertext = aes.encrypt(pad(timestamp))

result = b64encode(iv + ciphertext)
print(result.decode())