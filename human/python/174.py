from itertools import zip_longest

blocks = [b'SiEn', b'ptvl', b'lsey']
transposed = [bytes(t) for t in zip_longest(*blocks, fillvalue=0)]
print(transposed)