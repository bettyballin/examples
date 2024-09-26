
from binascii import hexlify, unhexlify
from itertools import cycle

# Assuming 's' is the hex representation of the plaintext,
# and 'key' is the hex representation of the key.
s = '636174'
key = '13'

def xor_cipher(hex_string, hex_key):
    # Convert the hex strings to bytes
    bytes_string = bytes.fromhex(hex_string)
    bytes_key = bytes.fromhex(hex_key)

    # XOR each byte of the string with the corresponding byte of the key
    # Using cycle to repeat the key if it's shorter than the string
    xored_bytes = bytes([b ^ k for b, k in zip(bytes_string, cycle(bytes_key))])

    # Convert the result back to a hex string
    return hexlify(xored_bytes).decode()

# Example use:
xored = xor_cipher(s, key)
print(x
