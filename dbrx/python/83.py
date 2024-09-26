import struct

# Assuming rsa_key is your 1024-bit decimal number as a string or integer
rsa_key = "1234567890123456789012345678901234567890"

with open('test', 'wb') as f:
    # Pack the key into bytes using '>Q' format (unsigned long long)
    for b in struct.pack('>Q', int(rsa_key, 16)):
        f.write(bytes([b]))