import secrets

def test_fermat(n):
    if (pow(secrets.randbelow(n - 1) + 1, (n - 1), n)) != 1:
        return False
    return True

n = 23  # number to test
print(test_fermat(n))