def FastModularExponentiation(b, k, m):
    res = 1
    while (k > 0):
        if ((k & 1) == 1):
            res = (res * b) % m
        k = k >> 1
        b = (b ** 2) % m
    return res

# Example usage:
b = 2
k = 3
m = 5
result = FastModularExponentiation(b, k, m)
print(result)