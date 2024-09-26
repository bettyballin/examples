
from itertools import zip_longest
import base64

def break_into_blocks(ciphertext, n):
    # Step 2: Break the ciphertext into n blocks
    blocks = [ciphertext[i::n] for i in range(n)]
    
    return blocks

def transpose_blocks(blocks):
    # Step 3: Transpose the blocks
    transposed_blocks = list(zip_longest(*blocks, fillvalue=0))
    # Convert the list of tuples back into a list of bytes objects
    transposed_bytes_blocks = [bytes(block) for block
