import binascii
import hashlib
import random
import sys

def unique_salt():
    rand = random.randint(0, sys.maxsize)
    return hashlib.sha1(binascii.unhexlify(format(rand, 'x'))).hexdigest()[:22]

print(unique_salt())