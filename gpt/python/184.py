
import secrets

def generate_secure_random_integer(n, m):
    return n + secrets.randbelow(m - n)

# Usage:
random_integer = generate_secure_random_integer(n, m)

