from itertools import zip_longest

ciphertext = b'ciphertext'
keylength = 3

blocks = [ciphertext[i:i+keylength] for i in range(0, len(ciphertext), keylength)]
# [b'cip', b'her', b'tex', b't']

transposed = [bytes(t) for t in zip_longest(*blocks, fillvalue=0)]
# [b'chtt', b'iee\x00', b'prx\x00']

print(blocks)
print(transposed)