def xor_hex(a, b):
    a = bytearray.fromhex(a)
    b = bytearray.fromhex(b)

    if len(a) != len(b):
        raise ValueError("Hex strings must be of equal length")

    return "".join([chr(x ^ y) for x, y in zip(a, b)])

# Test the function
print(xor_hex("123456", "abcdef"))