def extended_gcd(a, b):
    if a == 0:
        return (b, 0, 1)
    else:
        g, x, y = extended_gcd(b % a, a)
        return (g, y - (b // a) * x, x)

def genkey():
    p = 3
    q = 11
    n = p * q  # pubkey part 1
    z = (p-1)*(q-1)  # 20
    k = 7

    g, j, _ = extended_gcd(k, z)
    
    if g != 1:
        raise ValueError("No modular multiplicative inverse exists")

    return n, k, j % z

print(genkey())