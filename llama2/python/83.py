import base64
from Crypto.Cipher import AES
from Crypto import Random

key = b'Sixteen byte key'
iv = Random.new().read(AES.block_size)
cipher = AES.new(key, AES.MODE_CFB, iv)
msg = iv + cipher.encrypt(b'Attack at dawn...')
print(msg)
print(base64.b64encode(msg))

# Strip IV from ciphertext before decryption
ciphertext_without_iv = msg[16:]
cipher = AES.new(key, AES.MODE_CFB, msg[:16])
print(cipher.decrypt(ciphertext_without_iv))