import itertools
import string

others = ['B', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'V', 'W', 'Z']
dict1 = {k : [k] for k in string.ascii_uppercase if k not in others}

for i in itertools.permutations(others):
    dict2 = {k: [v] for k, v in zip(others, i)}
    print({**dict1, **dict2})