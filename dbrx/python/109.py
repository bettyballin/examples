import hashlib

def custom_hash(items):
    sorted_items = tuple(sorted(map(str, items)))
    return int(hashlib.sha256(bytes(str(sorted_items), 'utf-8')).hexdigest(), 16)

# Example usage:
item1 = (1, 'a', 2, 'b')
item2 = (2, 'c', 1, 'd')  # Note the different order and values

print(custom_hash(item1) == custom_hash(item2))  # False