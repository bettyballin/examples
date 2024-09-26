import random
import string

def generate_random_mapping():
    mapping = {}
    for i in range(26):
        mapping[string.ascii_lowercase[i]] = random.choice(string.ascii_lowercase)

    return mapping

print(generate_random_mapping())