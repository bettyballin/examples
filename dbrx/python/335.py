from Crypto.Cipher import AES
from Crypto.Util.Padding import pad
import base64

class MyCrypt():
    def __init__(self, key):
        self.key = key

    def encrypt(self, text):
        cryptor = AES.new(self.key, AES.MODE_ECB)
        length = 16
        text = pad(text.encode('utf-8'), cryptor.block_size)
        ciphertext = cryptor.encrypt(text)
        return base64.b64encode(ciphertext).decode('utf-8')

# Test the class
key = b'0123456789abcdef'
crypt = MyCrypt(key)
text = "Hello, World!"
encrypted_text = crypt.encrypt(text)
print(encrypted_text)