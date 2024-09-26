import os
import hashlib
from Crypto.Cipher import AES

class Cipher:

    @staticmethod
    def md5sum(raw):
        m = hashlib.md5()
        m.update(raw)
        return m.hexdigest()

    BS = AES.block_size

    @staticmethod
    def pad(s):
        return s

    @staticmethod
    def unpad(s):
        return s

    def __init__(self, key):
        self.key = Cipher.md5sum(key.encode())
        self.cnter_cb_called = 0
        self.secret = None

    def _reset_counter_callback_state(self, secret):
        self.cnter_cb_called = 0
        self.secret = secret

    def _counter_callback(self):
        self.cnter_cb_called += 1
        return self.secret[self.cnter_cb_called % Cipher.BS] * Cipher.BS


    def encrypt(self, raw):
        secret = os.urandom(Cipher.BS)
        self._reset_counter_callback_state(secret)
        cipher = AES.new(self.key.encode(), AES.MODE_CTR, counter=self._counter_callback)
        raw_padded = Cipher.pad(raw.encode())
        enc_padded = cipher.encrypt(raw_padded)
        return secret + enc_padded


    def decrypt(self, enc):
        secret = enc[:Cipher.BS]
        self._reset_counter_callback_state(secret)
        cipher = AES.new(self.key.encode(), AES.MODE_CTR, counter=self._counter_callback)
        enc_padded = enc[Cipher.BS:]
        raw_padded = cipher.decrypt(enc_padded)
        return Cipher.unpad(raw_padded).decode()


# Test the class
if __name__ == "__main__":
    cipher = Cipher("my_secret_key")
    encrypted = cipher.encrypt("Hello, World!")
    decrypted = cipher.decrypt(encrypted)
    print(f"Encrypted: {encrypted}")
    print(f"Decrypted: {decrypted}")