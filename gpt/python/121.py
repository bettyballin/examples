
def pseudo_random_shuffle(key, length=256):
    # Initialize the mapping with the range of values
    mapping = list(range(length))
    
    # Create a seed from the key
    seed = sum(ord(c) for c in key)
    
    # Perform a simple key scheduling to shuffle the mapping
    for i in range(length):
        # Use a simple hash function to generate a pseudo-random index
        seed = (seed * 31337 + ord(key[i % len(key)])) % length
        
        # Swap the current value with the value at the pseudo-random index
        mapping[i], mapping[seed] = mapping[seed], mapping[i]
    
    return mapping

# Your key
key = "testtest12"

# Get the shuffled mapping
shuffled_mapping = pseudo_random_shuffle(key)

# Verify that all values are unique (you can skip this step in production)
assert len(set(shuffled
