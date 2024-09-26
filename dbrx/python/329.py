from Crypto.Cipher import AES
import struct

data = '00112233445566778899aabbccddeeff'
key = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15'
aes = AES.new(key, AES.MODE_ECB)

encrypted_data = aes.encrypt(struct.pack(f'>Q', int(data, 16)))
print(encrypted_data.hex())