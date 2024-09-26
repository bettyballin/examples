
def cyclic_left_shift(value, shift_bits):
    # Ensure the value is within 16 bits
    value = limit_to_16_bits(value)
    # Perform the left shift
    left_shifted = value << shift_bits
    # Use bitwise OR to combine the overflow with the truncated shifted value
    result = (left_shifted | (left_shifted >> 16)) & 0xFFFF
    return result
