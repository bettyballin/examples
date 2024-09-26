def point_scalar_multiply(a, b, p, x, y, scalar):
    Q = (None, None)
    P = (x, y)

    for i in range(scalar.bit_length() - 1, -1, -1):
        mask = (1 - int(bin(scalar)[2:].zfill(scalar.bit_length())[i])) & 0xFFFFFFFF

        Q = point_add(a, b, p, (Q[0] * mask, Q[1] * mask), (P[0], P[1]))

        tempP = point_double(a, b, p, P[0], P[1])

        P = ((tempP[0] * mask) + (P[0] * (~mask & 0xFFFFFFFF)), 
             (tempP[1] * mask) + (P[1] * (~mask & 0xFFFFFFFF)))

    return Q

def point_add(a, b, p, P, Q):
    if P[0] is None:
        return Q
    if Q[0] is None:
        return P

    x1, y1 = P
    x2, y2 = Q

    if x1 == x2 and y1 == y2:
        return point_double(a, b, p, x1, y1)

    slope = (y2 - y1) * pow(x2 - x1, -1, p)

    x3 = (slope ** 2 - x1 - x2) % p
    y3 = (slope * (x1 - x3) - y1) % p

    return (x3, y3)

def point_double(a, b, p, x, y):
    slope = (3 * x ** 2 + a) * pow(2 * y, -1, p)

    x3 = (slope ** 2 - 2 * x) % p
    y3 = (slope * (x - x3) - y) % p

    return (x3, y3)