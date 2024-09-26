import itertools
from collections import OrderedDict
import string

seed = {
    'A': ['A'],
    'B': ['B', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'V', 'W', 'Z'],
    'C': ['C'],
    'D': ['D'],
    'E': ['E'],
    'F': ['B', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'V', 'W', 'Z'],
    'G': ['G', 'W'],
    'H': ['B', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'V', 'W', 'Z'],
    'I': ['I'],
    'J': ['B', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'V', 'W', 'Z'],
    'K': ['B', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'V', 'W', 'Z'],
    'L': ['B', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'V', 'W', 'Z'],
    'M': ['B', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'V', 'W', 'Z'],
    'N': ['N'],
    'O': ['O'],
    'P': ['P'],
    'Q': ['Q'],
    'R': ['R'],
    'S': ['S'],
    'T': ['T'],
    'U': ['U'],
    'V': ['B', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'V', 'W', 'Z'],
    'W': ['B', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'V', 'W', 'Z'],
    'X': ['X'],
    'Y': ['Y'],
    'Z': ['B', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'V', 'W', 'Z']
}

d = OrderedDict(sorted(seed.items(), key=lambda t: t[0]))
listOfList = d.values()

for i in itertools.product(*listOfList):
    # print the possible dict
    print(dict(zip(string.ascii_uppercase, i)))