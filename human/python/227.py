from itertools import permutations

def calculate_unique_mappings(input_letters, output_letters):
    if len(input_letters) != len(output_letters):
        raise ValueError("Input and output letters must have the same length")

    unique_mappings = []
    for p in permutations(output_letters):
        mapping = dict(zip(input_letters, p))
        unique_mappings.append(mapping)

    return unique_mappings

input_letters = ['a', 'b', 'c']
output_letters = ['x', 'y', 'z']

unique_mappings = calculate_unique_mappings(input_letters, output_letters)

for i, mapping in enumerate(unique_mappings):
    print(f"Mapping {i+1}: {mapping}")