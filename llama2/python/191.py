import string
import hashlib
import random

id = "1234"
random_string = ""
count = 0

# Generate a large number of random bytes (16 MB) to reduce the chance of collisions
random_bytes = b''.join(random.getrandbits(8).to_bytes(1, 'big') for _ in range(1024*1024*16))

# Use a cryptographically secure pseudorandom number generator
prng = hashlib.sha256(id.encode()).hexdigest()

while True:
    # Generate a random string of 32 characters using the PRNG
    random_string = hashlib.sha256((prng + str(count)).encode()).hexdigest()[0:32]

    # Compute the SHA-256 hash of the random string with the ID as salt
    random_string_with_salt = random_string + id
    random_string_hash = hashlib.sha256(random_string_with_salt.encode()).hexdigest()

    # Check if the hash matches a prefix of the form "0000"
    if random_string_hash.startswith("0000"):
        print(f"Found match: {random_string} with hash {random_string_hash}")
        break

    count += 1