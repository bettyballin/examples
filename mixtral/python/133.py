import secrets

def get_random(n, m):
    return n + secrets.randbelow((m - n))

# Usage
print(get_random(10, 25))