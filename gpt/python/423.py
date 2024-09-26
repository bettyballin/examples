
def Legendre(arr, modulo):
    exponent = (modulo - 1) // 2  # Make sure to use integer division
    for a in arr:
        candidate = pow(a,
