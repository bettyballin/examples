
hash_bytes = hash.digest()
big_endian_integer = int.from_bytes(hash_bytes, 'big')

