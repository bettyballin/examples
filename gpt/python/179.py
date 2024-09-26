
import binascii

def hex_to_text(s):
    return binascii.unhexlify(s)

def text_to_hex(t):
    return binascii.hexlify(t)

def xor_hex(a, b):
    # Ensure both hex strings are of the same length
    length = max(len(a), len(b))
    a = a.zfill(length)
    b = b.zfill(length)

    # Convert hex strings to binary strings
    a_bin = hex_to_text(a)
    b_bin = hex_to_text(b)

    # XOR the binary strings and return the result as hex
    xor_result = ''.join(chr(ord(x) ^ ord(y)) for x, y in zip(a_bin, b_bin))
    return text_to_hex(xor_result)

# Example usage:
hex1 = '1a2b3
