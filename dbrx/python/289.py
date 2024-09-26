import secrets

random_values = [secrets.randbelow(1 << 32) for _ in range(4)]
print(' '.join(map(str, random_values)))