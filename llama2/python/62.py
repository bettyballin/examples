import struct

with open('file.bin', 'wb') as f:
    num = int(1024 * 1024)
    f.write(struct.pack('>Q', num))