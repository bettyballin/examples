def FastModularExponentiation(b, k, m):
    return pow(b, pow(2, k), m)

# Example usage:
b = 2
k = 3
m = 10
result = FastModularExponentiation(b, k, m)
print(result)