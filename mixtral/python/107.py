import copy
from itertools import product

# Your initial mapping
mapping = {
    'A': ['A1', 'A2', 'A3'],
    'B': ['B1', 'B2'],
    'C': ['C1', 'C2', 'C3']
}

keys, values_lists = zip(*mapping.items())
values = [v for vs in values_lists for v in vs]

combinations = list(product(*values_lists))

all_mappings = []
for combination in combinations:
    new_dict = copy.deepcopy(mapping)

    # Update the dictionary with a single value from each key's possible values
    for i, (key, _) in enumerate(new_dict.items()):
        new_value = [combination[i]]

        if len(values) > 1:
            new_dict[key] = new_value

    all_mappings.append(new_dict)

print("Number of possible mappings:", len(all_mappings))