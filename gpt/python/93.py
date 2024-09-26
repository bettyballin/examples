
import secrets

# Generate a random number between 0 and 99 (inclusive)
secure_num = secrets.randbelow(100)

# Generate a random integer with 10 bits of entropy
secure_num_bits = secrets.randbits(10)

print(secure_num)
print(secure_num_bits)

