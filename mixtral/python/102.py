number = 12345678901234567890  # replace with your number

with open('test', 'wb') as f:
    # Convert the large number into bytes
    num_bytes = int(number).to_bytes((int(number).bit_length() + 7) // 8, byteorder='big')

    f.write(num_bytes)