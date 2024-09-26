def xor_strings(a, b):
    return "".join([chr(ord(x) ^ ord(y)) for (x, y) in zip(a[:len(b)], b)])

# Test the function
a = "Hello, World!"
b = "secretkey"
print(xor_strings(a, b))