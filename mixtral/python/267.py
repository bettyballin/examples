import math

def genkey():
    p = 3  # prime 1
    q = 11  # prime 2
    n = p * q  # pubkey part 1
    z = (p-1)*(q-1)  # 20
    k = 7  # coprime to z and pub key part 2

    j, _ = extended_gcd(k, z)

    return n, k, j

def extended_gcd(aa, bb):
    last_remainder, remainder = abs(bb), abs(aa % bb)

    x, y, lastx, lasty = 0, 1, 1, 0

    while remainder:
        last_remainder, (quotient, remainder) = remainder, divmod(last_remainder, remainder)

        x, lastx = lastx - quotient*x, x

        y, lasty = lasty - quotient*y, y

    return lastx * (-1 if aa < 0 else 1), lasty * (-1 if bb < 0 else 1)

print(genkey())