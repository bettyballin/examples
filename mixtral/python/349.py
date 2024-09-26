__round_number = 0

def key_schedule(key):
    if len(key) < 8:
        raise ValueError("Size is less than 8-Bytes")

    global __round_number

    shift_value = (21, 0)[__round_number in [1, 2, 9, 16]]

    for i in range(len(key)):

        if i == len(key) - 1:
            key[0] |= ((key[i] >> shift_value) & (0xFF << (8-shift_value)))

        else:

           key[i+1] = (((key[i])>>shift_value)&0xff)|((key[i + 1 ]<<(8 - shift_value))&0xff)

    __round_number += 1

    return bytearray(key)

# Example usage:
key = bytearray([0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08])
print(key_schedule(key))