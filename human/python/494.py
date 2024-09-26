import secrets

def is_composite(n):
    if pow(secrets.randbelow(n - 1) + 1, (n - 1), n) != 1:
        return True
    return False

# Test the function
n = 1009  # Example number to test
result = is_composite(n)
print(f"Is {n} composite? {result}")