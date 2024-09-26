import random

def genkey():
    n = random.randint(1, 1000)
    k = random.randint(1, 1000)
    j = (n, k)
    return n, k, j

n, k, j = genkey()
print(f"Public Key: ({n}, {k})")
print(f"Private Key: {j}")