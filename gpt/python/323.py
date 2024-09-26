
def FastModularExponentiation(b, k, m):
    # Compute the exponent 2^k first
    exponent = 1 << k  # This is equivalent to 2^k.
    
    # Now apply the fast modular exponentiation algorithm
    res = 1
    b = b % m
    while exponent > 0:
        if (exponent & 1) == 1:
            res = (res * b) % m
        exponent >>= 1
        b = (b * b) % m
    return res

# Test the function
print(FastModularExponentiation(2, 1, 10))  # Output should be 4

