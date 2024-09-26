plain_number = pow(number, d, n)
decrypted_message += '{:b}'.format(plain_number).rjust(block_size // 2 + len(tmp_text) - block_size % 2, '0')