import os

print(''.join(map(str, os.urandom(16).hex()[::8])))