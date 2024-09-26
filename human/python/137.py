import random

s = list('abcdefg')
random.seed(42)
for i in range(10):
    random.shuffle(s)
    print(''.join(s))