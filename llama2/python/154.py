from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.primitives.poly1305 import Poly1305
from cryptography.hazmat.backends import default_backend
from os import urandom

class ChaCha20:
    def __init__(self, key):
        self.key = key

    def encrypt(self, plaintext):
        cipher = Cipher(algorithms.ChaCha20(self.key, urandom(16)), mode=None, backend=default_backend())
        encryptor = cipher.encryptor()
        ciphertext = encryptor.update(plaintext) + encryptor.finalize()
        return ciphertext

    def decrypt(self, ciphertext):
        cipher = Cipher(algorithms.ChaCha20(self.key, ciphertext[:16]), mode=None, backend=default_backend())
        decryptor = cipher.decryptor()
        plaintext = decryptor.update(ciphertext[16:]) + decryptor.finalize()
        return plaintext

class Poly1305:
    def __init__(self, key):
        self.key = key

    def calculate_tag(self, data):
        poly = Poly1305.new(key=self.key, backend=default_backend())
        poly.update(data)
        return poly.finalize()

def get_random_bytes(n):
    return urandom(n)

class SecureChaCha20Poly1305:
    def __init__(self, key):
        self.cha_cha = ChaCha20(key)
        self.poly1305 = Poly1305(key)

    def encrypt(self, plaintext):
        nonce = get_random_bytes(16)
        ciphertext = self.cha_cha.encrypt(plaintext)
        mac = self.poly1305.calculate_tag(nonce + ciphertext)
        return nonce + ciphertext + mac

    def decrypt(self, ciphertext):
        nonce = ciphertext[:16]
        ciphertext = ciphertext[16:-16]
        mac = ciphertext[-16:]
        plaintext = self.cha_cha.decrypt(nonce + ciphertext)
        tag = self.poly1305.calculate_tag(nonce + plaintext)
        if tag != mac:
            raise ValueError("Invalid MAC")
        return plaintext

# example usage
key = urandom(32)
s = SecureChaCha20Poly1305(key)
plaintext = b"Hello, World!"
ciphertext = s.encrypt(plaintext)
print(s.decrypt(ciphertext))