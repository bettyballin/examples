__round_number = 1

def key_schedule(key):
    """
    A function that takes a key as bytes input and uses a permutation to mutate the key and return a
    mutated key that can act as be used as a sub-key for a DES-round. The permutation is right rotation by
    1-Bit for round 1 2 9 16 and 2-Bits for other rounds.
    """
    global __round_number

    shift_value = 1
    if __round_number in [1, 2, 9, 16]:
        shift_value = 1
    else:
        shift_value = 2

    key_int = int.from_bytes(key, byteorder="little")
    key_int = (key_int >> shift_value) & 0xFFFFFFFFFFFFFFFF  # mask to preserve 64 bits
    __round_number += 1

    return bytearray(key_int.to_bytes(8, byteorder="little"))

# Example usage
key = bytearray(b'\x01\x02\x03\x04\x05\x06\x07\x08')
for _ in range(16):
    key = key_schedule(key)
    print(key.hex())