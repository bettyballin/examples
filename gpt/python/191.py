
import os
import random
import string

def generate_password(length):
    alphabet = string.ascii_letters + string.digits + string.punctuation
    random_generator = random.SystemRandom() # Uses os.urandom
