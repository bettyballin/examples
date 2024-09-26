p = 101  # Define a prime number

def inv_mod_p(x):
    """
    Compute an inverse for x modulo p, assuming that x
    is not divisible by p.
    """
    if x % p == 0:
        raise ZeroDivisionError("Impossible inverse")
    return pow(x, p-2, p)

# Test the function
x = 3
try:
    result = inv_mod_p(x)
    print(f"The modular inverse of {x} modulo {p} is {result}")
except ZeroDivisionError as e:
    print(e)