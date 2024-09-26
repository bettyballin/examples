
import secrets

def is_probably_prime(n, k=5):  # k is the number of trials
    if n <= 1:
        return False
    # Fermat's little theorem test
    for _ in range(k):
        a = secrets.randbelow(n - 2) + 2  # ensures 1 < a < n
        if pow(a, n - 1, n) != 1:
            return False
