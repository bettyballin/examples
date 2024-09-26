
from sympy import mod_inverse

# Given public key components
e = 5
n = 203

# RSA modulus 'n' is the product of two primes p and q (n = p * q).
# Since n is small, we can factorize it manually or using a library.
# For example, 203 = 7 * 29, so p = 7 and q = 29.

p = 7
