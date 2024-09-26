
if check_integrity is True:
    crc = struct.pack('<I', zlib.crc32(plaintext) & 0xFFFFFFFF)
    plaintext += crc

