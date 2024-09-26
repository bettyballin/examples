import binascii

def hex_to_text(hex_str):
    # Filter out non-printable characters
    return ''.join([chr(x) for x in binascii.unhexlify(hex_str) if x >= 32])

def XoR(hex_str1, hex_str2):
    # Perform bitwise XOR operation directly on binary data
    return binascii.hexlify(bytes(a ^ b for a, b in zip(binascii.unhexlify(hex_str1), binascii.unhexlify(hex_str2)))).decode('utf-8')

# Example usage:
hex_str1 = "48656c6c6f20576f726c64"
hex_str2 = "696e76697369626c6521"

xored = XoR(hex_str1, hex_str2)
print(xored)

text = hex_to_text(xored)
print(text)