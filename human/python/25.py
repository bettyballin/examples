import itertools

def derangement(x):
    p = itertools.permutations(x)
    return (i for i in p if not any(i[k] == x[k] for k in range(len(x))))

# Example usage:
x = [1, 2, 3]
derangements = derangement(x)
for d in derangements:
    print(d)