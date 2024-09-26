from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend

# Generate a public key for demonstration purposes
ecdh_public_key = ec.generate_private_key(ec.SECP256R1(), default_backend()).public_key()

# Exchange public keys (numbers)
value_numbers = ecdh_public_key.public_numbers()

# Restore EC public key from numbers on the other side
restored_ecdh_public_key = ec.SECP256R1().public_key_from_numbers(value_numbers.x, value_numbers.y)

# Print restored key for verification
print(restored_ecdh_public_key.public_bytes(
    encoding=serialization.Encoding.X962,
    format=serialization.PublicFormat.UncompressedPoint
))