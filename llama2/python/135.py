import crccheck

def crc8(data):
    return crccheck.crc.Crc8.calc(data)

def adjust_key_length(message, key):
    crc = crc8(key.encode())
    adjusted_key = (crc << (8 - len(key))) % 256
    return adjusted_key

# Test the function
message = "Hello, World!"
key = "secret"
print(adjust_key_length(message, key))