import cryptography.hazmat.primitives.asymmetric.x25519 as x25519
import cryptography.hazmat.primitives.serialization as serialization

private_key = x25519.X25519PrivateKey.generate()
public_bytes = private_key.public_bytes(
        encoding=serialization.Encoding.DER,
        format=serialization.PublicFormat.SubjectPublicKeyInfo
)

with open("keyshare_kotlin", "rb") as f:
        keyshare_kotlin = f.read()
loaded_keyshare = serialization.load_der_public_key(public_bytes[:12] + keyshare_kotlin[14:])