from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes

# Generate a random 256-bit key and a random 128-bit initialization vector (nonce)
key = get_random_bytes(32)
nonce = get_random_bytes(16)

# Create a new AES-GCM cipher object with the given key and nonce
cipher = AES.new(key, AES.MODE_GCM, nonce)

# Encrypt some data
data = b'my secret data'
enc, tag = cipher.encrypt_and_digest(data)

# Decrypt the data
dec_cipher = AES.new(key, AES.MODE_GCM, nonce)
dec = dec_cipher.decrypt_and_verify(enc, tag)

print(dec)  # b'my secret data'