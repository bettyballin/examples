private_key_bytes = privateKey.__bytes__()
private_key_hex = hex(int.from_bytes(private_key_bytes, byteorder='big'))