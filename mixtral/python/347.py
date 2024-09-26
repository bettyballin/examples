import cryptography
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend

raw_public_key = "your_raw_public_key_here"

point_data = bytes.fromhex(raw_public_key)
srv_public_numbers = ec.EllipticCurvePublicNumbers(
    x=int.from_bytes(point_data[:32], byteorder='big'),
    y=int.from_bytes(point_data[32:64], byteorder='big')
)
curve = ec.SECP256R1()
srv_public_key = ec.EllipticCurvePublicKey.from_encoded_point(curve, srv_public_numbers.public_bytes(
    encoding=serialization.Encoding.X962,
    format=serialization.PublicFormat.UncompressedPoint
))