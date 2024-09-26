def generate_mappings(possible_mappings):
    # Base case - if there are no more letters left
    # return the current mapping as a list with one element
    if not any(len(value) > 1 for value in possible_mappings.values()):
        yield {k: [v] for k, v in possible_mappings.items()}
        
    else:
        letter = next(k for k, v in possible_mappings.items() if len(v) > 1)
        remaining_letters = set(possible_mappings.keys()) - {letter}
        
        # Iterate over all possibilities of the current letter
        for possibility in possible_mappings[letter]:
            new_possible_mappings = {
                **{k: v for k, v in possible_mappings.items() if len(v) == 1},
                letter: [possibility]
            }
            
            yield from generate_mappings(new_possible_mappings)

# Example usage:
possible_mappings = {
    'a': ['1', '2'],
    'b': ['3'],
    'c': ['4', '5']
}

for mapping in generate_mappings(possible_mappings):
    print(mapping)