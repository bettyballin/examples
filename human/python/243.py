def convert_to_hex(data):
    buf = ''
    for b in data:
        halfbyte = (b >> 4) & 0x0F
        two_halfs = 0
        while two_halfs < 2:
            buf += chr('0' + halfbyte) if 0 <= halfbyte <= 9 else chr('a' + (halfbyte - 10))
            halfbyte = b & 0x0F
            two_halfs += 1
    return buf