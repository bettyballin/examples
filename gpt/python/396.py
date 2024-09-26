
from hashlib import sha256

def hmac_sha256(key, msg):
    block_size = 64  # In bytes, SHA-256 uses a 64-byte block size

    # Ensure key is block_size bytes long by hashing or padding with zeros
    if len(key) > block_size:
        key = sha
