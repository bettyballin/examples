import hashlib
import binascii

def garbleString(string, salt, iteration, hash_algorithm):
    target = str.encode(string)
    dk = hashlib.pbkdf2_hmac(hash_algorithm, target, salt.encode(), iteration)
    hex_str = binascii.hexlify(dk).decode().lower()
    return (hex_str, salt, iteration)

# example usage:
print(garbleString("Hello, World!", "my_salt", 100000, "sha256"))