
import hashlib

hash_256 = hashlib.blake2b(digest_size=32)
hash_256.update(b"your data here")
print(hash_256.hexdigest())

