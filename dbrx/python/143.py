import hashlib

# Assuming you have a 128-bit integer as input
input_int = 12345678901234567890

# Convert int to bytes (assuming big-endian byte order)
byte_order = 'big'
num_bytes = (input_int.bit_length() + 7) // 8
input_bytes = input_int.to_bytes(num_bytes, byte_order)

# Hash the bytes using hashlib.sha256()
hash_object = hashlib.sha256(input_bytes)
digest = hash_object.digest()

print(digest.hex())