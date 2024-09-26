from itertools import permutations

def get_rearrangement_indices(in_string, out_string):
    # Generate all unique characters in both strings
    chars = set(in_string + out_string)
    
    # Find indices of each character in input string
    char_to_index = {char: [i for i, c in enumerate(in_string) if c == char] for char in chars}
    
    # Iterate over possible permutations and check against output string
    result = []
    for perm in permutations(chars):
        rearranged = ''.join([in_string[char_to_index[char][index]] for index, char in enumerate(perm)])
        if rearranged == out_string:
            indices = [char_to_index[char].index(i) for i, char in enumerate(in_string)]
            result.append(tuple(indices))
    
    return result