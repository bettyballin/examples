import binascii
import hashlib

def sha256(hex_str):
    return hashlib.sha256(binascii.unhexlify(hex_str)).digest()

first_part = "..."  # replace with actual hexadecimal representation

checksum = binascii.hexlify(
               sha256(sha256(first_part))[:4]
           ).decode("utf-8")

print(checksum)