import hashlib
import struct

class ChaCha20Poly1305:
    def __init__(self, is_encrypt, key, nonce):
        self.is_encrypt = is_encrypt
        self.key = key
        self.nonce = nonce
        self.poly_key = b'\x00' * 32
        self.poly_nonce = b'\x00' * 16
        self.poly_tag = b'\x00' * 16
        self.cipher_state = self.chacha20_init(key, nonce)

    def updateAAD(self, aad):
        self.poly_key = self.poly1305_mac(self.poly_key, aad)

    def update(self, data):
        if self.is_encrypt:
            encrypted_data = self.chacha20_encrypt(self.cipher_state, data)
            self.poly_key = self.poly1305_mac(self.poly_key, encrypted_data)
            return encrypted_data
        else:
            decrypted_data = self.chacha20_decrypt(self.cipher_state, data)
            self.poly_key = self.poly1305_mac(self.poly_key, data)
            return decrypted_data

    def calculate_tag(self):
        return self.poly1305_mac(self.poly_key, self.poly_nonce)

    def verify_tag(self, tag):
        if self.poly1305_mac(self.poly_key, self.poly_nonce) != tag:
            raise ValueError("Invalid tag")

    @staticmethod
    def chacha20_init(key, nonce):
        state = [0x61707865, 0x3320646e, 0x79622d32, 0x6b206574]
        for i in range(4):
            state[i + 4] = int.from_bytes(key[i*4:(i+1)*4], 'little')
        state[8] = int.from_bytes(nonce[:4], 'little')
        state[9] = int.from_bytes(nonce[4:8], 'little')
        state[10] = int.from_bytes(nonce[8:12], 'little')
        state[11] = int.from_bytes(nonce[12:], 'little')
        return state

    @staticmethod
    def chacha20_encrypt(state, data):
        encrypted_data = bytearray(len(data))
        for i in range(0, len(data), 64):
            block = data[i:i+64]
            state = ChaCha20Poly1305.chacha20_block(state)
            for j in range(len(block)):
                encrypted_data[i+j] = block[j] ^ state[j%16]
        return bytes(encrypted_data)

    @staticmethod
    def chacha20_decrypt(state, data):
        decrypted_data = bytearray(len(data))
        for i in range(0, len(data), 64):
            block = data[i:i+64]
            state = ChaCha20Poly1305.chacha20_block(state)
            for j in range(len(block)):
                decrypted_data[i+j] = block[j] ^ state[j%16]
        return bytes(decrypted_data)

    @staticmethod
    def chacha20_block(state):
        x = state[:]
        for i in range(10):
            ChaCha20Poly1305.quarter_round(x, 0, 4, 8, 12)
            ChaCha20Poly1305.quarter_round(x, 1, 5, 9, 13)
            ChaCha20Poly1305.quarter_round(x, 2, 6, 10, 14)
            ChaCha20Poly1305.quarter_round(x, 3, 7, 11, 15)
            ChaCha20Poly1305.quarter_round(x, 0, 5, 10, 15)
            ChaCha20Poly1305.quarter_round(x, 1, 6, 11, 12)
            ChaCha20Poly1305.quarter_round(x, 2, 7, 8, 13)
            ChaCha20Poly1305.quarter_round(x, 3, 4, 9, 14)
        for i in range(16):
            x[i] += state[i]
        return [x[i] & 0xffffffff for i in range(16)]

    @staticmethod
    def quarter_round(x, a, b, c, d):
        x[a] += x[b]
        x[d] ^= x[a]
        x[d] = (x[d] << 16) | (x[d] >> 16)
        x[c] += x[d]
        x[b] ^= x[c]
        x[b] = (x[b] << 12) | (x[b] >> 20)
        x[a] += x[b]
        x[d] ^= x[a]
        x[d] = (x[d] << 8) | (x[d] >> 24)
        x[c] += x[d]
        x[b] ^= x[c]
        x[b] = (x[b] << 7) | (x[b] >> 25)

    @staticmethod
    def poly1305_mac(key, data):
        r = int.from_bytes(key[:16], 'little')
        s = int.from_bytes(key[16:], 'little')
        a = 0
        p = 1 << 130
        for i in range(0, len(data), 16):
            block = data[i:i+16]
            n = int.from_bytes(block, 'little')
            a += n
            a = (a * r) % p
        a += s
        return a.to_bytes(16, 'little')

# Test vector from RFC 7539, sec 2.8.2
plaintext1 = b"Ladies and Gentlemen of the class "
plaintext2 = b"of '99: If I could offer you only one"
plaintext3 = b" tip for the future, sunscreen would be it."
nonce = bytes.fromhex("070000004041424344454647")
key = bytes.fromhex("808182838485868788898a8b8c8d8e8f909192939495969798999a9b9c9d9e9f")

# Encryption
ccEnc = ChaCha20Poly1305(True, key, nonce)
ccEnc.updateAAD(bytes.fromhex('50515253c0c1c2c3c4c5c6c7'))
ct1 = ccEnc.update(plaintext1)
ct2 = ccEnc.update(plaintext2)
ct3 = ccEnc.update(plaintext3)
tag = ccEnc.calculate_tag()

print("Ciphertext:\n%s\n" % (ct1 + ct2 + ct3).hex())
print("Tag:\n%s\n" % tag.hex())

# Decryption
ccDec = ChaCha20Poly1305(False, key, nonce)
ccDec.updateAAD(bytes.fromhex('50515253c0c1c2c3c4c5c6c7'))
dt1 = ccDec.update(ct1)
dt2 = ccDec.update(ct2)
dt3 = ccDec.update(ct3)
ccDec.verify_tag(tag)

print("Decrypted:\n%s\n" % (dt1 + dt2 + dt3))