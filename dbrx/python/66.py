from operator import xor

# Assuming key is a single-byte object representing one byte of our repeating-key cipher...
key = b'\x01'

transposedBlocks = [[b'\x00'], [b'\x01'], [b'\x02']]  # example data

transposedBlocksXored = [bytes(xor(b, key[0]) for b in block) for block in transposedBlocks]

print(transposedBlocksXored)