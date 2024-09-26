
from Crypto.Cipher import AES
from Crypto.Util import Counter
import os

# 1. Create a random nonce (number used once) for the counter
nonce = os.urandom(8)  # Using 8 bytes for the nonce

# 2. Create a Counter object with the nonce
ctr =
