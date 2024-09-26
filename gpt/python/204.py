
from Crypto.Cipher import AES
from Crypto.Util import Counter
import os

# Key size for AES-256 is 32 bytes (256 bits)
key = os.urandom(32)

# The block size for AES is always 128 bits, so the counter size is 128 bits
ctr = Counter.new(128)

# Create a new AES-256 CTR mode cipher object
obj = AES.new(key, AES.MODE_CTR,
