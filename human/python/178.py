# Choose a particular curve and prime.  We assume that p > 3.
p = 15733
a = 1
b = 3

class Point:
    def __init__(self, x, y):
        self.x = x % p
        self.y = y % p

O = Point(0, 0)

def valid(P):
    """
    Determine whether we have a valid representation of a point
    on our curve.  We assume that the x and y coordinates
    are always reduced modulo p, so that we can compare
    two points for equality with a simple ==.
    """
    if P == O:
        return True
    else:
        return (
            (P.y**2 - (P.x**3 + a*P.x + b)) % p == 0 and
            0 <= P.x < p and 0 <= P.y < p)

# Example usage:
P = Point(10, 20)
print(valid(P))