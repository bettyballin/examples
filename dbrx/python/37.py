import sys
import random
import hashlib

def mt_rand(low=0, high=sys.maxsize):
    """Generate a better random value"""
    return int(random.getrandbits(128))

def substr(s, start, length=None):
    """Returns the portion of string specified by the start and length parameters."""
    if len(s) < start:
        return False
    if not length:
        return s[start:]
    elif length > 0:
        return s[start:start + length]
    else:
        return s[start:length]

def unique_salt():
    random_bytes = mt_rand().to_bytes(16, byteorder='big')
    salt = hashlib.sha1(random_bytes).hexdigest()[:22]
    return substr(salt, 0)

password = "12345"
salt = unique_salt()
hash_value = hashlib.sha1((salt + password).encode('utf-8')).hexdigest()
print(hash_value)