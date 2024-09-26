from fractions import Fraction

def el_gamal_decrypt(a, b, k, p):
    return (pow(b, -k, p) * a) % p

# Example usage
a = 923
b = 15653
k = -3632
p = 262643

result = el_gamal_decrypt(a, b, k, p)
print(result == 152015)