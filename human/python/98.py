import os
import hashlib

print(hashlib.sha1(os.urandom(10)))
print(hashlib.sha1(os.urandom(10)).digest())
print(hashlib.sha1(os.urandom(10)).hexdigest())