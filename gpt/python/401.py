
#!/usr/bin/env python3

# Two prime numbers used in RSA.
p = 61
q = 53

# Compute n, which is part of the public key and also used in the private key.
n = p * q

# Compute Euler's totient function of n.
phi = (p - 1) * (q - 1)

# Extended Greatest Common Divisor algorithm.
# It's used to find the coefficients (x and y) that satisfy Bézout's identity: ax + by = gcd(a, b).
# For the modular inverse, we are interested in the coefficient x.
def egcd(a, b):
    if a == 0:
        return (b, 0, 1)
    g, y, x = egcd(b % a, a)
    # The recursive call is unpacked with new values
