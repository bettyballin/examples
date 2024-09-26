import os

# Generate a random 16-byte IV
iv = os.urandom(16)

# Define the plaintext
plaintext = b"Hello, World!"

# Perform XOR operation
first_block = int.from_bytes(bytes([x ^ y for x, y in zip(iv, plaintext[:16])]), byteorder='big')

print(first_block)