
import base64
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives.serialization import load_pem_private_key
from cryptography.hazmat.backends import default_backend

def generate_signature(base_string, private_key_pem, passphrase=None):
    # Load the private key with an optional passphrase
    private_key = load_pem_private_key(
        private_key_pem.encode(),
        password=passphrase.encode() if passphrase else None,
        backend=default_backend()
    )

    # Sign the base string using PKCS#1 v1.5 padding and SHA256
    signature = private_key.sign(
        data=base_string.encode(),
