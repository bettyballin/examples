from secrets import randbelow

def nonzero_random_bytes(n: int) -> bytes:
    return bytes(randbelow(255) + 1 for _ in range(n))

# Test the function
print(nonzero_random_bytes(10))