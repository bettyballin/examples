
def rotate_right(byte_array, bit_count):
    byte_array_len = len(byte_array)
    bit_count %= (byte_array_len * 8)  # Ensure the bit_count is within the byte array bit range

    # Convert bit rotation to byte rotation and additional bits if necessary
    byte_count, additional_bits = divmod(bit_count, 8)
    
    # Rotate bytes
    byte_array = byte_array[-byte_count:] + byte_array[:-byte_count]
    
    # If no additional bits to rotate, return the result
    if additional_bits == 0:
        return byte_array

    # Rotate additional bits if needed
    carry = 0
    for i in range(byte_array_len):
        byte_index = byte_array_len - 1 - i  # Start from the end
        new_carry = (byte_array[byte_index] & (0xFF >> (8 - additional_bits))) << (8
