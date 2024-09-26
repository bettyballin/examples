import hashlib

print((2 ** 128 - 1).to_bytes(16, 'little', signed=False))
print(hashlib.sha256((2 ** 128 - 1).to_bytes(16, 'little', signed=False)).hexdigest())