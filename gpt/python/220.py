
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec
from binascii import unhexlify

# Your hex keys as strings
private_key_hex = 'your_private_key_hex_string'
public_key_hex = 'your_public_key_hex_string'

# Convert hex to bytes
private_key_bytes = unhexlify(private_key_hex)
public_key_bytes = unhexlify(public_key_hex)

# Load the private key
private_key = ec.derive_private_key(int.from_bytes(private_key_bytes, 'big'), ec.SECP256R1(), default_backend())

# Load the public key
public_numbers = ec.EllipticCurvePublicNumbers(
    x=int.from_bytes(public_key_bytes[:32], 'big'),
    y=int.from_bytes(public_key_bytes[32:], 'big'),
    curve=ec.SECP256R1()
