# original list
byte_list = [128, 105, 110, 190, 6, 98, 143, 143, 90, 125, 108, 45, 180, 106, 181, 31]

# split into RGB tuples, padding with 0 if necessary
rgb_tuples = [(byte_list[i], byte_list[i+1], byte_list[i+2]) if i+2 < len(byte_list) else (byte_list[i], 0, 0) for i in range(0, len(byte_list), 3)]

# split into RGBA tuples, padding with 0 if necessary
rgba_tuples = [(byte_list[i], byte_list[i+1], byte_list[i+2], byte_list[i+3]) if i+3 < len(byte_list) else (byte_list[i], byte_list[i+1], byte_list[i+2], 0) if i+2 < len(byte_list) else (byte_list[i], 0, 0, 0) for i in range(0, len(byte_list), 4)]

print(byte_list)
print(rgb_tuples)
print(rgba_tuples)