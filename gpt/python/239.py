
import sys
import os
import ecdsa
from hashlib import sha256

def create_ecc_key(input_string):
    # Hash the input string to get a seed
    seed = sha256(input_string.encode('utf-8')).digest()

    # Use os.urandom to generate a random number
