from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import ec

# Generate the curve
curve = ec.SECP256R1()

# Create a private key
private_key = ec.generate_private_key(curve, default_backend())

print(private_key)