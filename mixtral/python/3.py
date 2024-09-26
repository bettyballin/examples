def xor_strings(a, b):
    return "".join([chr((x) ^ (y)) for (x, y) in zip(a[:len(b)], b)])

# Test the function
a = "Hello, World!"
b = "secretkey"
print(xor_strings(a, b))