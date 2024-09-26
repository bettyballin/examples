def binary_representation(n):
    hex_str = hex(n)[2:]
    binary_str = bin(int(hex_str, 16))[2:].zfill(32)
    result = ''
    for i in range(0, 32, 8):
        byte = binary_str[i:i+8]
        result += byte + '[' + str(int(byte, 2) % 2) + '] '
    return result.strip()

print("82514145")
print("= 0x3832353134313435")
print("= " + binary_representation(82514145))

print("\n93505044")
print("= 0x3933353035303434")
print("= " + binary_representation(93505044))