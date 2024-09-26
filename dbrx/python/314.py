import rsa
import json
from base64 import b64encode

private_key_pem = "path_to_your_private_key.pem"
actual = {"your_data": "to_sign"}

with open(private_key_pem, "rb") as key_file:
    private_key = rsa.PrivateKey.load_pkcs1(key_file.read())

signature = rsa.sign(json.dumps(actual).strip().encode(), private_key, 'SHA-256')
base64_signature = b64encode(signature)

print(base64_signature)