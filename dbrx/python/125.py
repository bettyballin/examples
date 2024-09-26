import zlib

def check_crc(crc, plaintext):
    if int.from_bytes(crc, byteorder='little') != zlib.crc32(plaintext):
        return False
    return True