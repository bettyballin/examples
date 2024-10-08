from Crypto.Cipher import AES

# Assuming key_bytes and iv_bytes from previous code snippet.
key_bytes = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15'
iv_bytes = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15'
ciphertext = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15'

cipher = AES.new(key_bytes, AES.MODE_CBC, iv_bytes)
decrypted_data = cipher.decrypt(ciphertext)

print(decrypted_data)