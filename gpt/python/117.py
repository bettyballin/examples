
import os

def generate_aes_128_key():
    key = os.urandom(16)  # 128 bits = 16 bytes
    # You can then save this key to a secure place.
    return key

# Generate
