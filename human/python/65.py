def xor_strings(xs, ys):
    return "".join(chr(ord(x) ^ ord(y)) for x, y in zip(xs, ys))

binary_a = "Hello, World!"
binary_b = "Goodbye, World!"
xored = xor_strings(binary_a, binary_b).encode("hex")
print(xored)