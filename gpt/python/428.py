
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.primitives.kdf.hkdf import HKDF
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives import serialization
from Crypto.Cipher import AES
from Crypto.Util.Padding import unpad
import base64

# ... (Your deriveKey function here)

derived_key = deriveKey()
iv = "1020304050607080"

test_enc = "y+In4kriw0qy4lji6/x14g=="
enc = base64.b64decode(test_enc)

cipher = AES.new(derived_key, AES.MODE_CBC, iv.encode('utf-8'))

# Decrypt once and unpad if necessary
decrypted_data = cipher.decrypt(enc)
try:
    unpadded_data = unpad(decrypted_data, AES.block_size)
    print(unpadded_data.decode('utf-8'))  # Should print '
