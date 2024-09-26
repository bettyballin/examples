
import os
import struct

# Function to generate a cryptographically secure random number
def get_secure_random():
    # Create a byte array of length 4 bytes (32 bits) for each integer
    # Multiply by 4 to get the desired number of integers
    num_values = 4
    random_bytes = os.urandom(4 * num_values)
    
    # Convert the bytes to an array of uint32 values
    random_uint32s = struct.unpack('<' + 'I' * num_values, random_bytes)
    
    # Join as a string without any separators
    random_string = ''.join(str(num
