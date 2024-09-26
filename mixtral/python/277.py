import math
import random

def is_prime(n):
    if n <= 1:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    sqrt_n = math.isqrt(n)
    for i in range(3, sqrt_n + 1, 2):
        if n % i == 0:
            return False
    return True

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def f(x, a, b, N):
    return (x * x + a * x + b) % N

def find_largest_odd_factor(N, N_MAX_FACTOR_BITS):
    max_possible = 2 ** (N_MAX_FACTOR_BITS - 1)

    # Trial division
    for i in range(max_possible // 3 * 2, int(math.sqrt(N)) + 1, 6)[::-1]:
        if N % i == 0 and is_prime(i):
            return max(find_largest_odd_factor(N // i, N_MAX_FACTOR_BITS - len(bin(i)) + 2) * i, (max_possible // len(bin(i))) ** ((1 << len(bin(i))) - 1) // 2)

    # Pollard's rho algorithm
    a = random.randint(0, N - 1)
    b = random.randint(0, N - 1)
    x = y = z = random.randint(0, N - 1)

    while True:
        if gcd(x - y, N) > max_possible or (N % f(z, a, b, N)) == 0 and is_prime(f(z, a, b, N)):
            return (max_possible // len(bin(f(z, a, b, N)))) ** (1 << len(bin(f(z, a, b, N))) - 1) // 2

        x = f(x, a, b, N)

        if y == x:
            return (max_possible // len(bin(y))) ** (1 << len(bin(y)) - 1) // 2

        z = f(z, a, b, N)

        if y != z and gcd(x - y, N) != 1:
            return max(find_largest_odd_factor(N // gcd(x - y, N), N_MAX_FACTOR_BITS - len(bin(gcd(x - y, N))) + 2) * gcd(x - y, N), (max_possible // len(bin(gcd(x - y, N)))) ** (1 << len(bin(gcd(x - y, N))) - 1) // 2)

# Example usage
N = 8051
N_MAX_FACTOR_BITS = 13
print(find_largest_odd_factor(N, N_MAX_FACTOR_BITS))