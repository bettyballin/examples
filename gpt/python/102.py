
from Crypto.Cipher import AES
import binascii

class IVCounter(object):
    def __init__(self, value):
        # Ensure the IV is in the correct format (bytes) initially
        self.value = binascii.unhexlify(value)

    def increment(self):
        # Increment the IV value as an integer, then convert back to bytes
        new_value = int(binascii.hexlify(self.value), 16) + 1
        # Ensure that the IV stays the same size (128 bits, or 16 bytes)
        self.value = new_value.to_bytes(16, byteorder='big')
        return self.value

class CTR:
    def __init__(self, k):
        self.key = binascii.unhexlify(k)

    def __strxor(self, a, b):  # xor two strings of equal lengths
        return bytes([x ^ y for x, y in zip(a, b)])

    def __split_len(self, seq, length):
        return [seq[i:i
