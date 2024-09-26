ciphertext = b"1,2,3,4,5"
result1 = bytearray(map(int, ciphertext.split(b',')))
result2 = bytearray(int(x) for x in ciphertext.split(b','))

print(result1)
print(result2)