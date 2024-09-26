bin_str1 = '10101010'
bin_str2 = '11110000'

result = ''.join(str(int(x) ^ int(y)) for x, y in zip(bin_str1, bin_str2))

print(result)