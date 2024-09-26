class EllipticCurve:
    def __init__(self, p):
        self.p = p

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

def add_points(self, P, Q):
    dydx = (Q.y - P.y) * pow(Q.x - P.x, self.p - 2, self.p)
    Zx = ((dydx**2 % self.p) + (-P.x - Q.x)) % self.p
    Zy = (((Zx - P.x) * dydx) % self.p + (P.y)) % self.p
    return Point(Zx, Zy)

# example usage
curve = EllipticCurve(23)
P = Point(3, 4)
Q = Point(5, 7)
result = add_points(curve, P, Q)
print(result.x, result.y)