from Crypto.Util.Padding import pad
from Crypto.Cipher import AES

# Define payload, derived_key and iv
payload = "Your payload here"
derived_key = b"Your 32 byte key here"
iv = b"Your 16 byte iv here"

# Pad your data before encryption using pkcs7
padded_data = pad(payload.encode(), AES.block_size)

cipher = AES.new(derived_key, AES.MODE_CBC, iv)
encrypted_data = cipher.encrypt(padded_data)

print(encrypted_data)