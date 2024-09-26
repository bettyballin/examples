
import os

# Generate a 16-byte random number
random_bytes = os.urandom(16)
random_number = int.from_bytes(random_bytes, byteorder='big')

print
