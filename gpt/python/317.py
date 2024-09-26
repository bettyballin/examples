
import nacl.utils
from nacl.public import PrivateKey
import binascii

# Generate a new private key
private_key = PrivateKey.generate()

# Get the raw private key bytes
private_key_bytes = private_key.encode()

# Convert the bytes to a hex string
private_key_hex = binascii.hexlify(private_key_bytes).decode('utf-8')

print(private_key_hex)

