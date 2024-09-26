
def modinv(a, p):
    # This function returns the modular inverse of a modulo p.
    # The modular inverse is an integer 'x' such that (a * x) % p == 1.
    return pow(a, p - 2, p)

def add(a, p, P, Q):
    # Check For Neutral Element
    if P == (0, 0) or Q == (0, 0):
        return (P[0] + Q[0]) % p, (P[1] + Q[1]) % p

    # Check For Inverses (Return Neutral Element - Point At Infinity)
    if P[0] == Q[0]:
        if (-P[1]) % p == Q[1] or (-Q[1]) % p == P[1]:
