from itertools import permutations, product
from collections import defaultdict

def get_rearrangement_indices(in_string, out_string):
    indices = defaultdict(list)
    for i, c in enumerate(in_string):
        indices[c].append(i)
    for perms in product(*map(permutations, indices.values())):
        inds = {c: iter(p) for c, p in zip(indices, perms)}
        yield tuple(next(inds[c]) for c in out_string)

# Example usage:
in_str = "abc"
out_str = "cab"
for indices in get_rearrangement_indices(in_str, out_str):
    print(indices)