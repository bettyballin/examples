x = [3, 1, 2]
s = bytearray(b'cat')
unshuffled = bytearray(c for i, c in sorted(zip(x, s)))
print(unshuffled)