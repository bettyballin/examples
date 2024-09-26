# Define the iv and plaintext variables
iv = b'\x01\x02\x03\x04\x05\x06\x07\x08'
plaintext = [b'\x11\x12\x13\x14\x15\x16\x17\x18']

# Perform the XOR operation
first_block = bytes([x^y for x, y in zip(iv, plaintext[0])])

# Print the result
print(first_block)