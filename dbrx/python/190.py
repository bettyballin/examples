c = b'Hello, World!'  # example bytes object
binary_string = ''.join(format(byte, '08b') for byte in c)
print(binary_string)