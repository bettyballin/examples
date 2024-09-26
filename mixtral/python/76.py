most_likely_keylen = 5  # replace with your actual key length
ciphertext = b'your_ciphertext_here'  # replace with your actual ciphertext

blocks = [ciphertext[i::most_likely_keylen] for i in range(most_likely_keylen)]
transposedBlocks = list(zip(*blocks))

# Convert tuples of integers back to bytes
result = b''.join([bytes(block) for block in transposedBlocks])

print(result)