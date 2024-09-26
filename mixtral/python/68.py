from Crypto.PublicKey import RSA
from Crypto.Random import get_random_bytes

# Generate public and private keys
key = RSA.generate(2048)
public_key = key.publickey()

# Define blocks of data to encrypt
blocks = [b'Hello, ', b'world! ', b'This ', b'is ', b'a ', b'test.']

# Encrypt blocks of data
encrypted_data = []
for b in blocks:
    encrypted_block = public_key.encrypt(b, 32)[0]
    encrypted_data.append(encrypted_block)

# Decrypt blocks of data
decrypted_blocks = [key.decrypt(e).decode() for e in encrypted_data]

# Print decrypted blocks
print(''.join(decrypted_blocks))