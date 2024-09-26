import json
import base64
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend

def order_dict(dictionary):
    return {k: order_dict(v) if isinstance(v, dict) else v
            for k, v in sorted(dictionary.items())}

async def sign_payload(private_key, data):
    """Generate a signature based on the data using the local private key."""
    ordered_data = order_dict(data)
    payload = json.dumps(ordered_data).encode('utf-8')
    sig = private_key.sign(
        payload,
        ec.ECDSA(hashes.SHA256())
    )
    return base64.b64encode(sig).decode()