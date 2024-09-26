
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.primitives import serialization

# Generate the private and public key pair
curve = ec.SECP256R1()
private_key = ec.generate_private_key(curve)
public_key = private_key.public_key()

# Extract raw public key bytes (concatenation of X and Y coordinates)
public_numbers = public_key.public_numbers()
x = public_numbers.x.to_bytes(32, byteorder='big')
y = public_numbers.y.to_bytes(32, byteorder='big')
raw_public_key = x + y  # This should be
