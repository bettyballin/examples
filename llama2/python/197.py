from Crypto.Cipher import AES

key = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15'
cipher = AES.new(key, AES.MODE_ECB)  # Create an AES-128 cipher with the given key