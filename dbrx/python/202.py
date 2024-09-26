import struct

def str_to_octets(s):
    return [x[0] for x in struct.iter_unpack('B', s.encode())]

s = "Men of few words are the best men."
octets = str_to_octets(s)
print(octets)  # Output: [77, 101, 110, ...]