def fast_mod_exp(b, exp, m):
    res = 1
    while exp > 1:
        if exp & 1:
            res = (res * b) % m
        b = b ** 2 % m
        exp >>= 1
    return (b * res) % m

# Example usage
b = 2
exp = 10
m = 100
result = fast_mod_exp(b, exp, m)
print(f"{b}^{exp} mod {m} = {result}")