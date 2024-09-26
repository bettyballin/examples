import random
import secrets
from math import gcd

def is_prime(n, k=5):  # number of tests to run
    if n < 2 or (n % 2 == 0 and n > 2):
        return False

    def check(a, s, d, n):
        x = pow(a, d, n)

        if x != 1:
            for _ in range(s - 1):
                if (x := ((pow(x, 2)) % n)) == n-1:
                    return True

            return False

        else:
            return True

    s = 0

    d = n - 1

    while d & 1 == 0:

        d //= 2

        s += 1

    for _ in range(k):

        a = random.randint(2, n-1)

        if gcd(a, n)>1 or not check(a, s, d, n):

            return False

    return True

def generate_prime():

    while True:

        p = secrets.randbits(500)

        if is_prime(p):

            break

    N = 2 * p + 1

    assert (is_prime(N))

    return N

print(generate_prime())