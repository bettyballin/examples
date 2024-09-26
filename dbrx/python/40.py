from Crypto.Cipher import AES
import os
import struct

class CTR:
    def __init__(self, k):
        self.key = k

    def encrypt(self, plaintext):
        nonce = os.urandom(8)
        counter = 0
        ciphertext = b''
        while len(ciphertext) < len(plaintext):
            ctr_block = struct.pack('>Q', (counter << 64) | int.from_bytes(nonce, 'big'))
            aes_ecb = AES.new(self.key.encode('utf-8'), AES.MODE_ECB)
            encrypted_ctr_block = aes_ecb.encrypt(ctr_block)
            xor_result = bytes([x ^ y for x, y in zip(plaintext[len(ciphertext):], encrypted_ctr_block)])
            ciphertext += xor_result
            counter += 1

        return nonce + ciphertext

    def decrypt(self, ciphertext):
        if len(ciphertext) < 16:
            raise ValueError('Ciphertext must be at least 128 bits long')

        nonce = ciphertext[:8]
        plaintext = b''
        ciphertext = ciphertext[8:]
        counter = 0
        while len(ciphertext) > 0:
            aes_ecb = AES.new(self.key.encode('utf-8'), AES.MODE_ECB)
            ctr_block = struct.pack('>Q', (counter << 64) | int.from_bytes(nonce, 'big'))
            encrypted_ctr_block = aes_ecb.encrypt(ctr_block)
            xor_result = bytes([x ^ y for x, y in zip(encrypted_ctr_block, ciphertext[:16])])
            plaintext += xor_result
            ciphertext = ciphertext[16:]
            counter += 1

        return plaintext

# Test the code
key = "my_secret_key"
ctr = CTR(key)
plaintext = b"This is a secret message"
ciphertext = ctr.encrypt(plaintext)
print(ciphertext)
decrypted = ctr.decrypt(ciphertext)
print(decrypted)