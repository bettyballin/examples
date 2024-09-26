def Legendre(arr, p):
    e = (p - 1) // 2
    results = [pow(a, e, p) for a in arr]
    return [(r-p if r > 1 else r) for r in results]

# Example usage:
arr = [1, 2, 3]
p = 5
print(Legendre(arr, p))