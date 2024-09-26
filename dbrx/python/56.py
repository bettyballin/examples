import random

def fisher_yates_shuffle(mapping):
    n = len(mapping)
    for i in range(n - 1, 0, -1):
        j = random.randint(0, i)
        mapping[i], mapping[j] = mapping[j], mapping[i]
    return mapping

# test the function
mapping = [1, 2, 3, 4, 5]
print(fisher_yates_shuffle(mapping))