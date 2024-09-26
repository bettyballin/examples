
# Your 1024-bit number, replace this with your actual number
number_1024_bit = 1234567890123456789012345678901234567890

# Calculate the number of bytes needed for 1024 bits
num_bytes = 1024 // 8

# Convert the number to bytes. '>' denotes big-endian byte order.
# You can also use '<' for little-endian byte order if needed.
number_bytes = number_1024_bit.to_bytes(num_bytes, byteorder='big')

# Write the bytes to a binary file
with open('test.bin', 'wb') as f:
    f.write(number_bytes)

