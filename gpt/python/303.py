
# c is the ciphertext in bytes, e.g., b'\xe4\x06-\x95\xf5!P4'
c = des.encrypt(y)

# Convert bytes to a binary string
binary_string = ''.join(format(byte, '08b') for byte in c)

