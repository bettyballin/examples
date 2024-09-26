
from Crypto.Cipher import DES3
from Crypto.Hash import MD5
from Crypto.Util.Padding import pad, unpad
from base64 import b64encode, b64decode

class Crypto:

    @staticmethod
    def md5_hash(value):
        hasher = MD5.new()
        hasher.update(value.encode('ascii'))
        return hasher.digest()

    @staticmethod
    def encrypt(string_to_encrypt):
        key = Crypto.md5_hash("L6#F&,q2$xLx")
        cipher = DES3.new(key, DES3.MODE_ECB)
        padded_text = pad(string_to_encrypt.encode('ascii'), DES3.block_size)
        encrypted_bytes = cipher.encrypt(padded_text)
        return b64encode(encrypted_bytes).decode('ascii')

    @staticmethod
    def decrypt(encrypted_string):
        key = Crypto.md5_hash("L6
