
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.backends import default_backend
from cryptography.exceptions import InvalidSignature

def verify_ecdsa_signature(public_key_pem, signature, message):
    # Load the public key from PEM format
    public_key = serialization.load_pem_public_key(
        public_key_pem,
        backend=default_backend()
    )

    try:
        # Verify the signature (ensure you use the correct hash algorithm)
        public_key.verify(
            signature,
            message,
            ec.ECDSA(hashes.SHA256())
