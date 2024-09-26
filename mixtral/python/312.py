import cryptography
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend

x = b'\x12\x34\x56\x78\x90\xab\xcd\xef'  # replace with your x value
y = b'\x12\x34\x56\x78\x90\xab\xcd\xef'  # replace with your y value

public_num = ec.EllipticCurvePublicNumbers(
    x=int.from_bytes(x, "big"),
    y=int.from_bytes(y, "big"),
    curve=ec.SECP256R1()
)

ecdh_public_key = public_num.public_key(default_backend())