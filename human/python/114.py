def h2bin(x):
    return bytes.fromhex(x.replace(' ', '').replace('\n', ''))

# Test the function
hex_string = "48 65 6c 6c 6f 20 57 6f 72 6c 64"
print(h2bin(hex_string))