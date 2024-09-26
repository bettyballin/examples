import binascii

ciphertext = "your_hex_encoded_ciphertext_here"
result = b"your_result_bytes_here"

cipher_bytes = binascii.unhexlify(ciphertext)
print("CIPHER BYTES:", cipher_bytes)

# Now compare the two
if result == cipher_bytes:
    print('Match!')
else:
    print('No match :-(')