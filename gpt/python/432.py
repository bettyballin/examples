
import json
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.primitives.serialization import load_pem_private_key

def load_private_key_from_pem(pem_data):
    return load_pem_private_key(pem_data, password=None)

def sign_payload(private_key, data):
    ordered_data = json.dumps(data, separators=(',', ':'), sort_keys=True).encode('utf-8')
    signature = private_key.sign(ordered_data, ec.ECDSA(hashes.SHA256()))
    return base64.b
