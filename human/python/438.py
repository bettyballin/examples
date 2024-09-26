# To convert a list of tuples back into a byte string.
from itertools import chain

# example list of tuples
tuples = [(104, 101, 108, 108, 111), (32, 87, 111, 114, 108, 100)]

print(bytes(chain.from_iterable(tuples)))