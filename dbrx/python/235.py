import hashlib

# Generate an output hash of the desired byte-length:
hash_256 = hashlib.blake2s(digest_size=32)
hash_384 = hashlib.blake2b(digest_size=48)

data = b'Hello World!'
hash_256.update(data)
print(hash_256.digest())

hash_384.update(data)
print(hash_384.digest())