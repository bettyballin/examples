
import os
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from cryptography.hazmat.primitives.ciphers.aead import ChaCha20Poly1305

# Derive key from the password
salt = os.urandom(16)  # Use a securely generated random salt
kdfpass = PBKDF
