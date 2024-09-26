import base64
from Crypto.Cipher import AES
from Crypto import Random

key = b'Sixteen byte key'
iv = Random.new().read(AES.block_size)
cipher = AES.new(key, AES.MODE_CFB, iv=iv)
msg = cipher.encrypt(b'Attack at dawn...')

# Prepend the IV to the encrypted message
full_message = iv + msg
print(base64.b64encode(full_message))

# Decryption
decipher = AES.new(key, AES.MODE_CFB, iv=iv)
plaintext = decipher.decrypt(msg)

print(plaintext)