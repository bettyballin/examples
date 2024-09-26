transposedBlocksXored = [[b'\x01\x02', b'\x03\x04'], [b'\x05\x06', b'\x07\x08']]  # example input
transposedBack = [bytes(b for t in zip(*block) for b in t if b != 0x00) for block in transposedBlocksXored]
print(transposedBack)