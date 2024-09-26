import itertools

s = 'abc'

permutations = [''.join(u) for u in itertools.permutations(s, 3)]
print(permutations)

product = [''.join(u) for u in itertools.product(*3*[s])]
print(product)