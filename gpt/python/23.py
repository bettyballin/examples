
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad
from base64 import b64encode
import os

def aes_encrypt(plaintext, key):
    # Ensure the key is 16, 24, or 32 bytes long (AES-128, AES-192, AES-256)
    if len(key) not in [16, 24, 32]:
        raise ValueError("Invalid key size")

    # Generate a random 16-byte IV for CBC mode
    iv = os.urandom(16)

    # Create an AES cipher object with the key and the IV
    cipher = AES.new(key, AES.MODE_CBC, iv)

    # Pad the plaintext to be a multiple of the block size (16 bytes for AES)
    padded_text = pad(plaintext.encode('utf-8'), AES.block_size, style='zero')

    # Encrypt the padded text
    ciphertext = cipher.encrypt(padded_text)

    # Concatenate the IV and
