class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __eq__(self, other):
        return self.x == other.x and self.y == other.y

def ec_add(P, Q):
    # assuming the elliptic curve equation is y^2 = x^3 + 7 (for example)
    p = 2**256 - 2**32 - 2**9 - 2**8 - 2**7 - 2**6 - 2**4 - 1  # prime modulus for secp256k1
    a = 0  # coefficient of x^3 term in the elliptic curve equation
    if P.x == Q.x and P.y == Q.y:
        s = (3 * P.x**2 + a) * pow(2 * P.y, p-2, p)
    else:
        s = (Q.y - P.y) * pow(Q.x - P.x, p-2, p)
    x = (s**2 - P.x - Q.x) % p
    y = (s * (P.x - x) - P.y) % p
    return Point(x, y)

P = Point(6, 15)
Q = Point(8, 1267)
R = Point(2, 3103)
TwoP = ec_add(P, P)
ThreeP = ec_add(TwoP, P)
# Compute 4P two different ways.
assert ec_add(P, ThreeP) == ec_add(TwoP, TwoP)
# Check the associative law.
assert ec_add(P, ec_add(Q, R)) == ec_add(ec_add(P, Q), R)