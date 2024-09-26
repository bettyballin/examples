from Crypto.Cipher import AES
from Crypto.Util.Padding import pad

class MyCrypt:
    def __init__(self, key):
        self.key = key

    def encrypt(self, plainText):
        cipher = AES.new(self.key, AES.MODE_ECB)
        encrypted_data = cipher.encrypt(pad(plainText, AES.block_size))
        return encrypted_data.hex()

key = b'PyxZO31GlgKvWm+3GLySzAAAAAAAAAAAAAAA'
plainText = 'y_device=y_C9DB602E-0EB7-4FF4-831E-8DA8CEE0BBF5'.encode('utf-8')
crypto = MyCrypt(key)
encrypt_data = crypto.encrypt(plainText)
print(encrypt_data)