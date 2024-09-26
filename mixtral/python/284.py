def xor_with_key(message, key):
    message = [int(bit) for bit in format(int.from_bytes(message.encode(), 'big'), '0b')]

    # Repeat the single-byte (8 bits) key to match input length
    repeated_key = []

    while len(repeated_key) < len(message):
        for bit in format(int.from_bytes(key.encode(), 'big'), '08b'):
            if len(repeated_key) >= len(message):
                break

            repeated_key.append(int(bit))

    # Perform XOR operation
    result = [a ^ b for a, b in zip(message, repeated_key)]

    return bytes([int(''.join(map(str, result[i:i+8])), 2) for i in range(0, len(result), 8)]).decode()

# Test the function
message = "cooking"
single_byte_key = "\x41"

print("Original message:", message)
encrypted_msg = xor_with_key(message, single_byte_key)
decrypted_msg = xor_with_key(encrypted_msg, single_byte_key)

print("Encrypted message:", encrypted_msg)
print("Decrypted message:", decrypted_msg)