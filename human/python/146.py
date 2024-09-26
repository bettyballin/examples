import os
import binascii

print(long(binascii.hexlify(os.urandom(16)), 16))