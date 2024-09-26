def prime_factors(n):
    """Returns all the prime factors of a positive integer"""
    factors = []
    d = 2
    while n > 1:
        while n % d == 0:
            factors.append(d)
            n //= d
        d += 1

    return factors

n = 9868690954602957859

primes = prime_factors(n)[-1]

print(primes)