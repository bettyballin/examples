import itertools

def generate_tuples():
    for i in range(256):
        yield (i)

for r, g, b, a in itertools.islice(itertools.product(generate_tuples(), repeat=4), None):
    # ...
    pass