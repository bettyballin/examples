from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import ec

# Create an EllipticCurve object for the desired parameters.
ecurve = ec.SECP256R1()

# Generate a private key using the default backend and specified elliptic curve.
key = ec.generate_private_key(ecurve, default_backend())

print(key.private_numbers())