binary_string = ''.join(format(byte, '08b') for byte in c)
plaintext2 = bin(int.from_bytes(arr[1].encode(), 'big'))[2:]
xor_result = ''.join(format(x ^ y, '08b') for x, y in zip(binary_string, plaintext2))
result_bytes = int(xor_result, 2).to_bytes((len(xor_result) + 7) // 8, 'big')