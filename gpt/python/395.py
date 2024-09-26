
from math import sqrt

def prime_factors(n):
    factors = {}
    # Handle 2 separately to allow for an increment of 2 in the next loop
    while n % 2 == 0:
        factors[2] = factors.get(2, 0) + 1
        n //= 2
    # Check for odd factors
    for i in range(3, int(sqrt(n)) + 1, 2):
        while n % i == 0:
            factors[i] = factors.get(i, 0) + 1
            n //= i
    # If n
