import os
import base64
from Crypto.Protocol.KDF import PBKDF2
from datetime import date

# Assuming case-id and name are variables, replace with actual values
case_id = "your_case_id"
name = "your_name"

salt = os.urandom(16)
key_size = 32
iterations = 1000

input_string = f"{date.today()}{case_id}{name}"

# Generate the key
derived_key = PBKDF2(input_string, salt, dkLen=key_size, count=iterations)

# Convert to base64 for easier handling
base64_encoded_key = base64.b64encode(derived_key).decode('utf-8')

print(base64_encoded_key)