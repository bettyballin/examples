
def xor_hex_strings(a, b):
    # Convert hex strings to byte arrays
    bytes_a = bytes.fromhex(a)
    bytes_b = bytes.fromhex(b)
    
    # Perform XOR between the bytes
    xor_result = bytes([x ^ y for x, y in zip(bytes_a, bytes_b)])
    
    # Convert the bytes back to a hex string
    return xor_result.hex()

# Hex strings
a = "32510ba9a7b2bba9b8005d43a304b5714cc0bb0c
