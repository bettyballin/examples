from collections import defaultdict

def find_permutations(char_pos, indices_list, num_unique_chars, results):
    if len(indices_list) == num_unique_chars:
        results.append(tuple(sorted([i for i in indices_list])))
    else:
        for char, pos in char_pos.items():
            if char not in indices_list:
                find_permutations(char_pos, indices_list + [char], num_unique_chars, results)

# Example usage:
char_pos = defaultdict(list)
char_pos['A'].append(1)
char_pos['B'].append(2)
char_pos['C'].append(3)

num_unique_chars = 3
results = []

find_permutations(char_pos, [], num_unique_chars, results)

for result in results:
    print(result)