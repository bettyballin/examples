from Crypto.Util.Padding import unpad
from Crypto.Cipher import AES
import base64

# Define the test_enc variable
test_enc = "your_base64_encoded_data"

# Define the cipher object
key = b"your_secret_key_here"
cipher = AES.new(key, AES.MODE_ECB)

# Decrypt your data using PyCryptodome
decrypted_data = cipher.decrypt(base64.b64decode(test_enc))

# Unpad decrypted data to get back original plaintext
unpadded_data = unpad(decrypted_data, AES.block_size)

print(unpadded_data)