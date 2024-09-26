import secrets

def rand_int(n: int, m: int):
    return secrets.randbelow(m - n) + n

# example usage:
print(rand_int(1, 100))