import struct

def decrypt(block):
    return struct.pack('>H', (4142 - int(block, 10)) % 65536)