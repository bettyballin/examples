from Crypto.Cipher import AES
from base64 import b64encode

hex_key = 'A35EC217E15C1DD258201A184814897C'
key = bytes.fromhex(hex_key)

plaintext = 'Attack at dawn!!'
plaintext = plaintext.encode()  # Convert to bytes
obj = AES.new(key, AES.MODE_ECB)
ciphertext = obj.encrypt(plaintext)

print(b64encode(ciphertext).decode())