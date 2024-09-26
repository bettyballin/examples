import os
from Crypto import Random

# Generate AES key
key = Random.get_random_bytes(16)

# Convert the bytes to integers
ints = [i for i in bytearray(key)]

# Split into tuples of 3
tuples = []
for i in range(0, len(ints), 3):
    tup = (ints[i] % 256, ints[i+1] % 256 if i < len(ints) - 1 else None,
           ints[i+2] % 256 if i <= len(ints) - 2 else None)
    tuples.append((tup[0], tup[-1]))

# Add padding to the last tuple
if len(tuples[-1]) < 3:
    for _ in range(3 - len(tuples[-1])):
        tuples[-1] += (None,)

print("Tuples:", tuples[:5], "..." if len(tuples)>6 else "")