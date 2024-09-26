import json
import base64
from cryptography.fernet import Fernet

def encrypt_json(data, cipher):
    json_dump = json.dumps(data).encode()
    return base64.urlsafe_b64encode(cipher.encrypt(json_dump))

# Usage
my_dict = {"key": "value"}
cipher_suite = Fernet.generate_key()
cipher_suite = Fernet(cipher_suite)
encrypted_text = encrypt_json(my_dict, cipher_suite)
print(encrypted_text)