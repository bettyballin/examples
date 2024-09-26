from Crypto.Random import get_random_bytes

# Generate a 16-byte (128-bit) cryptographically strong pseudorandom number:
random_number = get_random_bytes(16)

print(random_number)