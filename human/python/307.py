from binascii import hexlify, unhexlify

def XORfunction(input_1, input_2):
    input_1 = bytearray(unhexlify(input_1))
    input_2 = bytearray(unhexlify(input_2))
    return hexlify(bytearray(
        a ^ b for a, b in zip(input_1, input_2))).decode('utf-8')

# Test the function
input_1 = "1234567890abcdef"
input_2 = "fedcba0987654321"
print(XORfunction(input_1, input_2))