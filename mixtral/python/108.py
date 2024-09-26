import os
from cryptography.hazmat.primitives import ciphers
from cryptography.hazmat.primitives.ciphers import algorithms, modes
from cryptography.hazmat.backends import default_backend
import struct

# Generate a random key
key = os.urandom(32)

counter_iv = 112

# Convert the integer to bytes
counter_bytes = struct.pack(">Q", counter_iv)[-8:]

cipher = ciphers.Cipher(
    algorithms.AES(key),
    modes.CTR(counter_bytes),
    backend=default_backend()
)

encryptor = cipher.encryptor()

plaintext = b"a secret message"
ciphertext = encryptor.update(plaintext) + encryptor.finalize()

print(ciphertext)