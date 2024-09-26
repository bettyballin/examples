
def dlog(g, t, p):
    from math import gcd

    def inverse(x, p): return pow(x, p - 2, p)

    def f(xab):
        x, a, b = xab[0], xab[1], xab[2]
        if x < p
