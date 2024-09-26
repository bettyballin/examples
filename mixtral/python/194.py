import hashlib

# Your input number
num = 12345

# Convert the number into bytes
bytes_representation = num.to_bytes((num.bit_length() + 7) // 8, 'big')

# Hash it using SHA256
hashed_value = hashlib.sha256(bytes_representation).digest()

print(hashed_value)