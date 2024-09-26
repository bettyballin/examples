from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend
import binascii

private_key = ec.generate_private_key(ec.SECP256R1(), default_backend())
raw_bytes = private_key.private_bytes(
    encoding=serialization.Encoding.X962,
    format=serialization.PrivateFormat.Raw,
    encryption_algorithm=serialization.NoEncryption()
)

print(binascii.hexlify(raw_bytes))