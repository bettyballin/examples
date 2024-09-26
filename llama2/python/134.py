import binascii

class Block:
    def __init__(self, value):
        self.value = value

    def xor(self, other):
        return Block(bytes(x ^ y for x, y in zip(self.value, other.value)))

class IV(Block):
    pass

iv = IV(b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15')
plaintext = [Block(b'Hello, World!')]

first_block = iv.xor(plaintext[0])