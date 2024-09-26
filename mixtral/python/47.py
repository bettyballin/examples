def unpack(x, b):
    return [int((x >> (i * b)) & ((1 << b) - 1))
            for i in range(((x.bit_length() + b-1) // b))]

# Usage
your_large_integer = 0x1234567890abcdef
limb_size = 8
limbs = unpack(your_large_integer, limb_size)
print(limbs)