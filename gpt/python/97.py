
import sys
import random
import hashlib

def mt_rand(low=0, high=sys.maxsize):
    """Generate a better random value"""
    return random.randint(low, high)

def substr(s, start, length=None):
    """Returns the portion of the string specified by the start and length parameters."""
   
