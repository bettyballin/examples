import hashlib

print(2 ** 128 - 1)  # largest 128-bit value
print(len(str(2 ** 128 - 1)))
print(str(2 ** 128 - 1).encode('ASCII'))  # ascii bytes
print(hashlib.sha256(str(2 ** 128 - 1).encode('ASCII')).hexdigest())