import base64
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.x509 import load_der_x509_public_key

def compute_shared_secret(ephemeral_public_key: str) -> bytes:
    key = base64.b64decode(ephemeral_public_key)
    public_key = load_der_x509_public_key(key)

    # Extract the raw elliptic curve point (uncompressed format).
    uncompressed_point = public_key.public_bytes(
        encoding=ec.Encoding.X962,
        format=ec.PublicFormat.UncompressedPoint
    )

    server_private_key = ec.generate_private_key(ec.SECP256R1())
    shared_secret = server_private_key.exchange(ec.ECDH(), ec.EllipticCurvePublicKey.from_encoded_point(ec.SECP256R1(), uncompressed_point))
    return shared_secret

# Example usage:
ephemeral_public_key = "your_base64_encoded_public_key_here"
shared_secret = compute_shared_secret(ephemeral_public_key)
print(shared_secret)