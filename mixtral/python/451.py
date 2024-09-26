from Crypto.Cipher import AES
from Crypto.Util import Padding
import base64

class MyCrypt():
    def __init__(self, key, iv):
        self.key = key
        self.iv = iv

    def encrypt(self, text):
       crypto = AES.new(self.key, mode=AES.MODE_CBC, IV=self.iv)

       padded_text = Padding.pad(text.encode('utf-8'), 16)

       ciphertext = crypto.encrypt(padded_text)

       return base64.b64encode(ciphertext).decode('utf-8')

# Example usage:
my_crypt = MyCrypt(b'0123456789abcdef', b'0123456789abcdef')
encrypted_text = my_crypt.encrypt('Hello, World!')
print(encrypted_text)