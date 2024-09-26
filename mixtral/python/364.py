from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend

# Generate private key
client_private = ec.generate_private_key(ec.SECP256k1(), default_backend())

# Derive the corresponding public key
client_public = client_private.public_key()

# Convert to bytes
server_public_key = ec.generate_private_key(ec.SECP256k1(), default_backend()).public_key()
server_pub_bytes = server_public_key.public_bytes(
    encoding=serialization.Encoding.X962,
    format=serialization.PublicFormat.UncompressedPoint
)
server_pubXBytes = server_pub_bytes[:32]
server_pubYBytes = server_pub_bytes[32:]

client_pub_bytes = client_public.public_bytes(
    encoding=serialization.Encoding.X962,
    format=serialization.PublicFormat.CompressedPoint
)
client_pubXBytes = client_pub_bytes[1:33]
client_pubYBytes = b''

print(server_pubXBytes)
print(server_pubYBytes)
print(client_pubXBytes)
print(client_pubYBytes)