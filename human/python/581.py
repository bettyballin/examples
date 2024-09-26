import random

s = "example_string"
seed = 42

x = list(range(len(s)))
random.Random(seed).shuffle(x)

print(x)