from Crypto import Random
from Crypto.Cipher import AES
from Crypto.Util import Counter

# Initialization Vector
iv = b'\x00\x01\x02\x03'

key = b"1234567890123456"

counter = Counter.new(AES.block_size * 8, initial_value=int.from_bytes(iv, 'big'))

cipher = AES.new(key, AES.MODE_CTR, counter=counter)