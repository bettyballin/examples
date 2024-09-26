import itertools

def generate_mappings(possible_mappings):
    keys = list(possible_mappings.keys())
    values = list(possible_mappings.values())
    for combination in itertools.product(*values):
        yield dict(zip(keys, combination))

possible_mappings = {'A': ['A', 'B'], 'B': ['F', 'G']}
for mapping in generate_mappings(possible_mappings):
    print(mapping)