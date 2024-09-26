from bitstring import BitArray

def key_schedule(key):
    if len(key) < 8:
        raise ValueError("Size is less than 8-Bytes")

    global __round_number
    shift_value = 1 if __round_number in [1, 2, 9, 16] else 2

    ba = BitArray(bytes=key)
    rotated_ba = (ba << (len(ba) - shift_value)).reverse()
    key_ = bytearray(rotated_ba.tobytes())

    print(key_)
    return key_

__round_number = 1
key_schedule(bytearray([0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08]))