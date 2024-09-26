
from Crypto.Cipher import AES
from Crypto.Util import Counter
import os

# Use a secure random key for AES encryption
key = os.urandom(32)

# Initialize a counter for CTR mode
ctr = Counter.new
