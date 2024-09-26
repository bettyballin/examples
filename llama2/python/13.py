from Crypto.Cipher import AES
from Crypto.Util import pad

# Define a key and initialization vector (IV) for AES encryption
key = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15'
iv = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15'

# Create a new AES cipher object
cipher = AES.new(key, AES.MODE_CBC, iv)

# Define the data to be encrypted
data = b'Hello, World!'

# Pad the data to a multiple of the block size
padded_data = pad(data, 16)

# Pad the last block of the file
ciphertext = cipher.encrypt(padded_data)

print(ciphertext)