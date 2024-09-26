from itertools import zip_longest

blocks = [[1, 2, 3], [4, 5, 6], [7, 8]]  # example input
transposed = [bytes(t) for t in zip_longest(*blocks, fillvalue=0)]

print(transposed)