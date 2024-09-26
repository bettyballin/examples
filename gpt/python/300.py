
def genkey():
    p = 3  # prime 1
    q = 11  # prime 2
    n = p * q  # pubkey part 1
    z = (p - 1) * (q - 1)  # 20
    k = 7  # coprime to z and pub key part 2

    # Calculate the modular multiplicative inverse of k modulo z
    # j * k ≡ 1 (mod z)
    j = pow(k, -1, z)

    return (n, k, j)

# Usage
n, k, j = genkey()
print("Public key: (n={}, k={})".format(n,
