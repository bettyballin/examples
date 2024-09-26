from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes

# Generate a random 128-bit IV.
iv = get_random_bytes(16)

# Generate a random 256-bit key.
key = get_random_bytes(32)

# Data to be encrypted
data = b"This is the data to be encrypted"

# Pad the data to a multiple of the block size (16 bytes for AES)
def pad(data):
    padding_length = 16 - len(data) % 16
    return data + bytes([padding_length]) * padding_length

dataPadded = pad(data)

def card_encrypt(iv, key, data):
    # Create a new AES cipher object with the given key and IV
    cipher = AES.new(key, AES.MODE_CBC, iv)
    # Encrypt the data
    return cipher.encrypt(data)

ciphertext = card_encrypt(iv,key, dataPadded)
print (ciphertext)