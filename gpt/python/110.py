
from Crypto.Cipher import AES
import os
import hashlib

# Function to pad the message to be encrypted
PADDING = '0'
BLOCK_SIZE = 32  # AES block size is 16 bytes, but BLOCK_SIZE is for padding

pad = lambda s: s + (BLOCK_SIZE - len(s) % BLOCK_SIZE) * PADDING

# Function to encode a string to AES compatible format
EncodeAES = lambda c, s: c.encrypt
