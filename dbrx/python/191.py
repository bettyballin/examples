arr = ["test", "hello"]
binary_string = "01101010"

plaintext2 = bin(int.from_bytes(arr[1].encode(), 'big'))[2:]
xor_result = ''.join(format(x ^ y, '08b') for x, y in zip(map(int, binary_string), map(int, plaintext2)))

print(xor_result)