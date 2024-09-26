from itertools import product
from string import ascii_letters

for k in product(*3*[ascii_letters]):
    str_key = ''.join(k)
    print(str_key)