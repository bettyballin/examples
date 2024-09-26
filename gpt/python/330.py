
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import ec

# Choose the curve you want to use for your key
curve = ec.SECP256R1()  # or ec.SECP384R1(), ec.SECP521R1(), etc.

# Generate the private key
private_key = ec.generate_private_key(curve, default_backend())

# To get the public key
public_key = private_key.public_key()

# Optionally, you can serialize the private and public keys if you need to store them
from cryptography.hazmat.primitives import serialization

private_bytes = private_key.private_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PrivateFormat.PKCS8,
    encryption_algorithm=serialization.NoEncryption()
)

public_bytes = public
