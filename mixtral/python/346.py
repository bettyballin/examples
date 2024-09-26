x = peer_public_key.public_numbers().x
peer_public_pkt = x.to_bytes((x.bit_length() + 7) // 8, byteorder='big')