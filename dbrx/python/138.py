import base58

def decode_base58check(base58_string):
    decoded = base58.b58decode(base58_string)
    return bytes.fromhex(decoded.hex()[2:-8])

# Replace '5Lagt' with your known part of the WIF compressed private key.
known_part_hex = b'\x80' + bytes.fromhex(''.join(['{:02x}'.format(ord(c)) for c in base58.b58decode('5Lagt')]))
missing_chars_count = 10

for i in range(58**missing_chars_count):
    candidate_base58_string = 'K' + ''.join([base58.b58chars[(i // (58**j)) % 58] for j in reversed(range(missing_chars_count))])
    try:
        decoded_candidate_hex = decode_base58check(candidate_base58_string)
        if known_part_hex[1:] == decoded_candidate_hex[:-4]:
            print(f'Found a match: {candidate_base58_string}')
            break
    except ValueError as e:
        continue

# If no matches are found you may need to increase the missing_chars_count or adjust the known_part_hex.