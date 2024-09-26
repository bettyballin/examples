def add(P, Q, a, p):
    # Check For Neutral Element
    if P == (0, 0) or Q == (0, 0):
        return (P[0] + Q[0], P[1] + Q[1])

    # Check For Inverses (Return Neutral Element - Point At Infinity)
    if P[0] == Q[0]:
        if (-P[1]) % p == Q[1] or (-Q[1]) % p == P[1]:
            return (0, 0)

    # Calculate Slope
    s = 0

    if P != Q:
        s = ((Q[1] - P[1])) * pow((Q[0] - P[0]), p-2, p) % p

    else:
        num = (3 * (P[0] * P[0]) + a)
        deno = 2 * P[1]
        s = ((num) * pow(deno, p-2, p)) % p

    # Calculate Third Intersection
    x = (s * s - P[0] - Q[0]) % p
    y = (s * (P[0] - x) - P[1]) % p
    return (x, y)