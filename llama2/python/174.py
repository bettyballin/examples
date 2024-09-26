import os
from cryptography.hazmat.primitives.ciphers.aead import ChaCha20Poly1305
from cryptography.hazmat.backends import default_backend

def generate_nonce():
    return os.urandom(12)

password = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15\x16\x17\x18\x19\x20\x21\x22\x23\x24\x25\x26\x27\x28\x29\x30\x31'
original_salt = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12'

chacha = ChaCha20Poly1305(password, backend=default_backend())
nonce = generate_nonce()
encrypted = chacha.encrypt(nonce, original_salt, None)
print(encrypted)

with open("nonce", "wb") as f:
    f.write(nonce)