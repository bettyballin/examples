
def unpack(x, b):
    b = 2 ** b  # The base is 2 to the power of the number of bits per limb
    r = []
    while x > 0:  # Continue until x is reduced to 0
        x, limb = divmod(x, b)  # Get the next limb
        r.append(limb)
    return r

# Example usage:
x = 123456789012345678901234567890
b = 32  # Number of bits per limb
limbs = unpack(x, b)
print(limbs)  #
