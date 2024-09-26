a = int('0b' + '10100111', base=2)
b = int('0b' + '10000000', base=2)

print(bin(a ^ b)[2:])