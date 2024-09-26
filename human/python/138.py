from random import seed, shuffle

r = list(range(5))  # convert range to list
key = 'zap'
seed(key)
shuffle(r)
print(r)