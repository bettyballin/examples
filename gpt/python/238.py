
import hashlib

def int_to_bytes(i, min_length=16):
    # Convert integer to bytes, ensuring it's at least min_length bytes. 16 bytes for 128 bits.
    return i.to_bytes(min_length, byteorder='big')

def hash_int(i):
    # Convert the integer to bytes
    int_bytes = int_to_bytes(i)
    # Hash the bytes using SHA256
    hash_obj = hashlib.sha256(int_bytes)
    # Return the hexadecimal digest
    return hash_obj.hexdigest()

# Example usage:
my_int = 12345678901234567890  # Replace with your 128-bit integer
hashed_int = hash_int(my_int)
print(hashed_int)

