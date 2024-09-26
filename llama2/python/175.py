from cryptography.hazmat.primitives.ciphers.aead import ChaCha20Poly1305
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend

# Load the key from storage
with open("key", "rb") as f:
    key = f.read(32)

# Load the nonce from storage
with open("nonce", "rb") as f:
    nonce = f.read(12)

# Load the ciphertext from storage
with open("ciphertext", "rb") as f:
    ciphertext = f.read()

# Decrypt the file
chacha = ChaCha20Poly1305(key)
plaintext = chacha.decrypt(nonce, ciphertext, None)

# Write the plaintext to a file
with open("plaintext", "wb") as f:
    f.write(plaintext)