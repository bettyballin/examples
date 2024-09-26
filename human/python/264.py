from Crypto.Random import Random
from Crypto.Cipher import AES
import base64

key = b'Sixteen byte key'

# encryption
iv = Random.new().read(AES.block_size)
cipher = AES.new(key, AES.MODE_CFB, iv)
msg = iv + cipher.encrypt(b'Attack at dawn...')
print (msg)
print (base64.b64encode(msg))

# decryption
cipher = AES.new(key, AES.MODE_CFB, msg[:16])
print (cipher.decrypt(msg[16:]))