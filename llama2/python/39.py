import os

n = 7  # you need to specify the number of bytes
random_number = int.from_bytes(os.urandom(n), byteorder='big')

print(random_number)