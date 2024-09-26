import hashlib

def create_pseudo_rand_table(key):
    table = {}
    hash_value = hashlib.sha256(key.encode()).hexdigest()
    for i in range(256):
        table[i] = int(hash_value[i%64], 16)
    return table

key = "testtest12"
mapping = create_pseudo_rand_table(key)
print(mapping)