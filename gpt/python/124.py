
from Crypto.PublicKey import RSA
from Crypto import Random
from Crypto.Cipher import PKCS1_OAEP

# Generate RSA keys
random_generator = Random.new().read
key = RSA.generate(1024, random_generator)
public_key = key.publickey()
cipher = PKCS1_OAEP.new(public_key)

# Read the file
with open('yourfile.txt', 'rb') as f:
    data = f.read()

# Encrypt data in chunks
chunk_size = 86  # 1024 bit key
