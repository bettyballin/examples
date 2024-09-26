
import itertools

def generate_mappings(mapping_dict):
    # Generate all possible combinations of mappings for each letter
    all_combinations = list(itertools.product(*(mapping_dict[key] for key in sorted(mapping_dict))))
    # Convert each combination into a dictionary
    possible_dictionaries = []
    for combination in all_combinations:
        # Ensure that each letter maps to a unique value
        if len(set(combination)) == len(combination):
            possible_dictionaries.append(dict(zip(sorted(mapping_dict), combination)))
    return possible_dictionaries

# Your initial mapping dictionary
mapping_dict = {
    'A': ['A'],
    'B': ['B', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'V', 'W', 'Z'],
    # ... (include all other mappings here)
    'Z': ['B', 'F', 'G',
