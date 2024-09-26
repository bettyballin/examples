from itertools import zip_longest

ciphertext = b'SplitsEvenly'
keylength = 4

blocks = [ciphertext[i:i+keylength] for i in range(0, len(ciphertext), keylength)]
# [b'Spl', b'its', b'Eve', b'nly']

transposed = [bytes(t) for t in zip_longest(*blocks, fillvalue=0)]
# [b'SiEn', b'ptvl', b'lsey']

print(blocks)
print(transposed)