import cryptography
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec

# Assuming value is a byte string containing the encoded public key
value = b'...'  # Replace with actual value

ecdh_public_key = ec.EllipticCurvePublicKey.from_encoded_point(
    curve=ec.SECP256R1(),
    data=value
)

# Example usage:
print(ecdh_public_key.public_bytes(
    encoding=serialization.Encoding.X962,
    format=serialization.PublicFormat.SubjectPublicKeyInfo
))