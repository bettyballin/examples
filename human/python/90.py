import os

random_bytes = os.urandom(10)
print(random_bytes)
print(type(random_bytes))
print(list(map(ord, random_bytes)))