
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad
from Crypto.Random import get_random_bytes
import os

# Helper functions to convert integers to bytes and vice versa
def int_to_bytes(value, length):
    return value.to_bytes(length, byteorder='big')

def bytes_to_int(bytes_value):
    return int.from_bytes(bytes_value, byteorder='big')

# Function to encrypt an integer
def encrypt_integer(value, key):
    # AES key must be either 16, 24, or 32 bytes long
    aes_key = key.ljust(32)[:32].encode('utf-8')
    cipher = AES.new(aes_key, AES.MODE_ECB)
    
    # Convert integer to 16 bytes and pad if necessary
    plaintext = pad(int_to_bytes(value, 
