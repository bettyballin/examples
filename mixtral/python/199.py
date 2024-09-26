import os
import base64
from Crypto.Protocol.KDF import HKDF

input_string = "your_input_string_here".encode()
salt = os.urandom(32)
info = b"AES encryption key derivation"

# Generate the derived key
derived_key = HKDF(input_key=input_string, length=32, salt=salt, info=info).read()

base64_encoded_key = base64.b64encode(derived_key)
print(base64_encoded_key)