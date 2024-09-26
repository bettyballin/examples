
import binascii
from Crypto.PublicKey import RSA

def multiplicative_inverse(e, phi):
    # A simple implementation of the Extended Euclidean Algorithm to find the modular inverse
    # You can also use the built-in pow function with three arguments: pow(e, -1, phi)
    g, x, y = gcd_extended(e, phi)
    if g != 1:
        raise Exception('Modular inverse does not exist')
    else:
        return x % phi

def gcd_extended(a, b):
    # Extended Euclidean Algorithm
    if a == 0:
        return (b, 0, 1)
    else:
        g, y, x = gcd_extended(b
