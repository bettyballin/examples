import base64
import json
from cryptography.fernet import Fernet

def decrypt_json(data, cipher):
    json_dump = base64.urlsafe_b64decode(data).decode()
    return json.loads(cipher.decrypt(bytes(json_dump, 'utf-8')).decode('utf-8'))

# Usage
cipher_suite = Fernet.generate_key()
cipher = Fernet(cipher_suite)
encrypted_text = cipher.encrypt(json.dumps({"key": "value"}).encode('utf-8'))
original_dict = decrypt_json(encrypted_text, cipher)
print(original_dict)