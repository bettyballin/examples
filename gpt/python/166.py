
import struct
import os
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend

backend = default_backend()
key = os.urandom(32)
counter_iv = 112

# Convert integer to a 16-byte string (big-endian)
nonce = struct.pack('>QQ', 0, counter_iv)  # Two 8-byte (64-bit) parts

# Make sure the nonce is 16 bytes
assert len(nonce) == 16

cipher = Cipher(algorithms.AES(key), modes.CTR(nonce), backend=backend)
encryptor = cipher.encryptor()
ciphertext = encryptor.update(b"a secret message") + encryptor.finalize()

