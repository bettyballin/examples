from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend

publicEc = ec.EllipticCurvePublicKey.from_encoded_point(
    ec.SECP256R1(),
    bytes.fromhex(this.ephemeralPublicKey)
)