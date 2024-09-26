import numpy as np

# Assuming 'tuples' is a list of tuples
tuples = [(1, 2, 3), (4, None, 6), (7, 8, 9)]

# Convert tuples back to a flat integer array
flat_ints = [i if i is not None else 0 for tup in tuples for i in tup]

# Create numpy array
array = np.zeros((len(tuples), len(tuples[0])), dtype=np.uint8)

for row, tuple_list in enumerate(tuples):
    for col, val in enumerate(tuple_list):
        if val is not None:
            array[row, col] = val
        else:
            array[row, col] = 0

print(array)