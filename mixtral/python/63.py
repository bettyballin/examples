import hashlib
from typing import List

def create_pseudo_rand_table(key: str) -> List[int]:
    # Generate hash for key
    hashed = int.from_bytes(hashlib.sha1(key.encode()).digest(), byteorder='big')

    mapping = list(range(256))

    j = 0

    # Shuffle the table using modular arithmetic
    for i in range(len(mapping)):
        hashed = (hashed + mapping[i]) % 256
        j = (j + hashed) % 256
        mapping[i], mapping[j] = mapping[j], mapping[i]

    return mapping