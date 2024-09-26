import os

def nonzero_random_bytes(n: int) -> bytes:
    result = bytearray()
    while len(result) < n:
        byte = os.urandom(1)
        if byte != b'\x00':
            result.append(byte[0])
    return bytes(result)

# Test the function with a length of 10
print(nonzero_random_bytes(10))