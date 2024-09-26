def egcd(a, b):
    x, y, u, v = 0, 1, 1, 0
    while a != 0:
        q, r = b // a, b % a
        m, n = x - u * q, y - v * q
        b, a, x, y, u, v = a, r, u, v, m, n

    gcd = b

    # Ensure d is positive
    if (x < 0):
        return gcd, x + b
    else:
        return gcd, x