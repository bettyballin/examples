#!/usr/bin/env python3

import string
import random

def generate_password(length):
    characters = string.ascii_letters + string.digits + string.punctuation
    return ''.join((random.SystemRandom().choice(characters)) for i in range(length))

if __name__ == "__main__":
    print(generate_password(10))