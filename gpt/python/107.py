
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad
import binascii

aes_key = b'\x26\x33\x3B\x48\x28\x69\x77\x8C\x14\xA2\xBE\xC1\xD4\xE2\xFD\x14'
aes = AES.new(aes_key, AES.MODE_ECB)
data = b'testtesttesttest'

# Ensure the data is a multiple of the block size
padded_data = pad(data, AES.block_size)

encrypted_data = aes.encrypt(padded_data)
print(binascii.hexlify(encrypted_data))

