from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import ec

# Private key
private_key = bytes.fromhex('YOUR_PRIVATE_KEY')
private_key_obj = ec.derive_private_key(private_key, curve=ec.SECP256k1(), backend=default_backend())
private_pem = private_key_obj.private_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PrivateFormat.PKCS8,
    encryption_algorithm=serialization.NoEncryption()
)

# Public key
public_key = bytes.fromhex('YOUR_PUBLIC_KEY')
public_key_obj = ec.EllipticCurvePublicKey.from_encoded_point(ec.SECP256k1(), public_key)
public_pem = public_key_obj.public_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PublicFormat.SubjectPublicKeyInfo
)

print(private_pem)
print(public_pem)