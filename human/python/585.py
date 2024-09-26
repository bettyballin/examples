from cryptography.hazmat.primitives.asymmetric.ec import ECDH
from cryptography.hazmat.primitives.asymmetric.ec import EllipticCurvePublicKey
from cryptography.hazmat.primitives.asymmetric.ec import SECP256R1
from cryptography.hazmat.primitives.serialization import load_pem_private_key

def compute_shared_secret(ephemeral_public_key: bytes) -> bytes:
    curve = SECP256R1()
    public_key = EllipticCurvePublicKey.from_encoded_point(curve, ephemeral_public_key)
    server_private_key = load_pem_private_key(b'your_private_key_here', password=None)
    shared_secret = server_private_key.exchange(ECDH(), public_key)
    return shared_secret

# Example usage
private_key = b'-----BEGIN PRIVATE KEY-----\nyour_private_key_here\n-----END PRIVATE KEY-----'
ephemeral_public_key = b'your_ephemeral_public_key_here'

shared_secret = compute_shared_secret(ephemeral_public_key)
print(shared_secret)