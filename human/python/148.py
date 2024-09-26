import os

with open('/dev/random', 'r') as f:
    print(f.read())