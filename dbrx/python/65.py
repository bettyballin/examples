from itertools import zip_longest

ciphertext = b'your_ciphertext_here'  # replace with your ciphertext
most_likely_keylength = 10  # replace with your key length

blocks = [ciphertext[i:i+most_likely_keylength] for i in range(0, len(ciphertext), most_likely_keylength)]

transposedBlocks = list(zip_longest(*blocks, fillvalue=bytes.fromhex('00')))

print(transposedBlocks)