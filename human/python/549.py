hex_string = "000102030405060708090a0b0c0d0e0f101112131415161718191a1b1c1d1e1f"
bytes_object = bytes.fromhex(hex_string)

with open("output.bin", "wb") as f:
    f.write(bytes_object)