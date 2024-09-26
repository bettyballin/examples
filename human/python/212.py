def point_add(a, b, p, x1, y1, x2, y2):
    if x1 == None:
        return (x2, y2)
    if x2 == None:
        return (x1, y1)
    if x1 == x2 and y1 != y2:
        return (None, None)
    if x1 == x2 and y1 == y2:
        lam = (3 * x1 * x1 + a) * pow(2 * y1, -1, p)
    else:
        lam = (y2 - y1) * pow(x2 - x1, -1, p)
    x3 = (lam * lam - x1 - x2) % p
    y3 = (lam * (x1 - x3) - y1) % p
    return (x3, y3)

def point_double(a, b, p, x, y):
    if x == None:
        return (None, None)
    lam = (3 * x * x + a) * pow(2 * y, -1, p)
    x3 = (lam * lam - 2 * x) % p
    y3 = (lam * (x - x3) - y) % p
    return (x3, y3)

def point_scalar_multiplication_double_and_add(a, b, p, x, y, scalar):
    """
    Implement Point multiplication with a scalar:
        r * (x, y) = (x, y) + ... + (x, y)    (r times)

    Reminder of Double and Multiply algorithm: r * P
        Q = Inf
        for i = 0 to num_bits(P)-1
            if bit i of P == 1 then
                Q = Q + P
            P = 2 * P
        return Q
    """
    Q = (None, None)
    P = (x, y)
    binary = bin(scalar)
    binary = binary[2:]   # get rid of 0b

    NUM_BITS = 64
    # pre-pad binary with 0s - 1010 becomes 0000000...00001010
    binary = '0' * (NUM_BITS - len(binary)) + binary

    # reverse binary and iterate over bits
    for b in binary[::-1]:
        if b == '1':
            Q = point_add(a, b, p, Q[0], Q[1], P[0], P[1])
        P = point_double(a, b, p, P[0],P[1])

    return Q