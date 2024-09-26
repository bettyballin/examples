def add_modulo_two(bin1, bin2):
    return '{0:b}'.format((int(bin1, 2) ^ int(bin2, 2)))

# Test the function
print(add_modulo_two('101', '110'))