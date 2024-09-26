from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend

# Generate ECDH private/public key
ecdh_private_key = ec.generate_private_key(ec.SECP256R1(), default_backend())
ecdh_public_key = ecdh_private_key.public_key()

# Exchange public keys (bytes)
value_bytes = ecdh_public_key.public_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PublicFormat.SubjectPublicKeyInfo
)

# Restore EC public key from bytes on the other side
restored_ecdh_public_key = serialization.load_pem_public_key(
    value_bytes,
    backend=default_backend()
)