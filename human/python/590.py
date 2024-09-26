import asyncio
import json
import base64
from cryptography.hazmat.primitives import serialization, hashes
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.primitives.asymmetric import utils
from cryptography.hazmat.backends import default_backend

async def main():
    # Generate key pair
    private_key = ec.generate_private_key(ec.SECP256R1(), default_backend())
    public_key = private_key.public_key()

    # Export public key in X.509/SPKI format, DER encoded
    public_key_bytes = public_key.public_bytes(
        encoding=serialization.Encoding.DER,
        format=serialization.PublicFormat.SubjectPublicKeyInfo
    )
    print("Public key:", base64.b64encode(public_key_bytes).decode())

    # Sign data
    data = {
        "data_1": "The quick brown fox",
        "data_2": "jumps over the lazy dog"
    }
    data_str = json.dumps(data)
    data_bytes = data_str.encode()
    signature = private_key.sign(data_bytes, ec.ECDSA(hashes.SHA256()))
    print("Signature:", base64.b64encode(signature).decode())

asyncio.run(main())