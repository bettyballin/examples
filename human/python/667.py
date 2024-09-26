from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend

public_key_bytes = b'\x04\x6b\x7f\x53\x53\xd2\x3f\x7a\x47\x58\x8c\x35\x13\x58\x33\x4f\x6a\x6b\x4a\x2a\x65\x35\x4f\x2a\x43\x58\x33\x35\x4f\x6a\x6b\x4a'
apple_public_key = ec.EllipticCurvePublicKey.from_encoded_point(ec.SECP256R1(), public_key_bytes)