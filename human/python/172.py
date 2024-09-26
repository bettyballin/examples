from itertools import zip_longest

def transpose_ciphertext(ciphertext, keylength):
    blocks = [ciphertext[i:i+keylength] for i in range(0, len(ciphertext), keylength)]
    transposed = [bytes(t) for t in zip_longest(*blocks, fillvalue=0)]
    return transposed

ciphertext = b'ciphertext'
keylength = 3

result = transpose_ciphertext(ciphertext, keylength)
for block in result:
    print(block)