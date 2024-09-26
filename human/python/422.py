def FastModularExponentiation(b, k, m):
    b %= m
    for _ in range(k):
        b = b ** 2 % m
    return b

# Example usage:
b = int(input("Enter base number: "))
k = int(input("Enter exponent: "))
m = int(input("Enter modulus: "))

result = FastModularExponentiation(b, k, m)
print("Result:", result)