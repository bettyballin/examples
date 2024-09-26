
import base64
from itertools import cycle

def xor_encrypt_decrypt(data, key):
    return ''.join(chr(ord(c) ^ ord(k)) for c, k in zip(data, cycle(key)))

# Usage:
original_data = "MySecretData"
key = "simplekey"

# Simple XOR Encryption
encrypted = xor_encrypt_decrypt(original_data, key)
print(f"Encrypted: {base64.b64encode(encrypted.encode()).decode()}")

# Decode from base64 before decrypting
decoded_encrypted = base64.b64decode(encrypted).decode
