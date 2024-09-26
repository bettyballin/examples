
import base64
from Crypto.Cipher import AES
from Crypto import Random

key = b'Sixteen byte key'
iv = Random.new().read(AES.block_size)
cipher_encrypt = AES.new(key, AES.MODE_CFB, iv)
plaintext = b'Attack at dawn...'
encrypted_message = iv + cipher_encrypt.encrypt(plaintext)

print(encrypted_message)
print(base64.b64encode(encrypted_message))

# Create a new cipher object for decryption
cipher_decrypt = AES.new(key, AES.MODE_CFB, iv)
#
