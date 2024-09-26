import operator

# assuming iv and plaintext are defined elsewhere
iv = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15'
plaintext = [b'Hello, World!']

first_block = bytes(map(operator.xor, iv, plaintext[0]))