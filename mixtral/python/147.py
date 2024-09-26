import struct
from Crypto.Cipher import AES

class AESCipher:
    def __init__(self, key):
        self.key = key.encode()

    def encrypt(self, data):
        cipher = AES.new(self.key, AES.MODE_ECB)
        return cipher.encrypt(data)

data = [1, 2, 3, 4, 5]  # assuming data is a list of integers
lol = []

for i in range(0, len(data)):
    byte_data = struct.pack('i', data[i])
    encrypted_byte_data = AESCipher("a11a454508421079").encrypt(byte_data)
    lol.append(encrypted_byte_data)

print(lol)