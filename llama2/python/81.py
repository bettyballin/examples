from Crypto.Cipher import AES

# Define the key (16 bytes for AES)
key = b'0123456789abcdef'

# Create a cipher object with CTR mode and a counter parameter
cipher = AES.new(key, AES.MODE_CTR, nonce=b'\0'*8, initial_value=1234567890)