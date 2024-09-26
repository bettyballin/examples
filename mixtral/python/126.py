def xor_hex(a, b):
    # Convert the input to integers
    int_a = int(a, 16)
    int_b = int(b, 16)

    # Perform XOR operation
    result = hex(int_a ^ int_b)[2:]

    return '0'*(len(result) % 2) + result

# Test the function
print(xor_hex('1a2b', '3c4d'))