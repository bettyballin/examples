import random

def generate_mappings(dict):
    if len(dict) == 26:
        return [dict]
    else:
        extensions = []
        for letter in 'ABCDEFGHIJKLMNOPQRSTUVWXYZ':
            if letter not in dict:
                new_dict = {**dict, letter: random.choice('ABCDEFGHIJKLMNOPQRSTUVWXYZ')}
                extensions.extend(generate_mappings(new_dict))
        return extensions

# Example usage:
mappings = generate_mappings({})
for mapping in mappings:
    print(mapping)