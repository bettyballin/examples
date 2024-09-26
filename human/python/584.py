import random

# setup
s = bytearray(b"abcdefghijklmnopqrstuvxwyz")
seed = 12345
random.Random(seed).shuffle(s)

# shuffle a sorted range, so that we can match the shuffled indicies to the unshuffled indicies
x = list(range(len(s)))
random.Random(seed).shuffle(x)

# match each shuffled index to the shuffled value, and then sort (based on the index) back into their unshuffled positions
unshuffled = bytearray(c for i, c in sorted(zip(x, s)))
print(unshuffled)