import struct

with open('file.bin', 'wb') as f:
    num = int(1024 * 1024)
    bytes = struct.pack('>Q', num)
    f.write(bytes)