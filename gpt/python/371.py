
from Crypto.Cipher import AES
from Crypto.Util.Padding import unpad
import codecs

def decrypt_aes(ciphertext, key, iv):
    # Ensure that the key and IV are the correct size (AES-256 uses a 32-byte key and a 16-byte IV)
    if len(key) != 32:
        raise ValueError("Key must be 32 bytes (256 bits) long")
    if len(iv) != 16:
        raise ValueError("IV must be 16 bytes (128 bits
