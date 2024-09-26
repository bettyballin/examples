import zlib
from Crypto.Cipher import AES

class Encryptor:
    def __init__(self, key):
        self.key = key

    def encrypt(self, plaintext):
        integrity_check = zlib.crc32(plaintext)
        cipher = AES.new(self.key, AES.MODE_ECB)
        ciphertext = cipher.encrypt(self._pad(plaintext))
        return ciphertext + integrity_check.to_bytes(4, byteorder='big')

    def decrypt(self, ciphertext, check_integrity=False):
        cipher = AES.new(self.key, AES.MODE_ECB)
        plaintext = self._unpad(cipher.decrypt(ciphertext[:-4]))
        if check_integrity and zlib.crc32(plaintext) != int.from_bytes(ciphertext[-4:], byteorder='big'):
            raise ValueError("Integrity check failed")
        return plaintext

    def _pad(self, data):
        padding_length = AES.block_size - len(data) % AES.block_size
        return data + bytes([padding_length]) * padding_length

    def _unpad(self, data):
        padding_length = data[-1]
        return data[:-padding_length]

# Usage
key = b'\x00' * 16
encryptor = Encryptor(key)
plaintext = b'Hello, World!'
ciphertext = encryptor.encrypt(plaintext)
decrypted = encryptor.decrypt(ciphertext, check_integrity=True)
print(decrypted)