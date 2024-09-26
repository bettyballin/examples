from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import rsa

# Generate a new private key
private_key = rsa.generate_private_key(
    public_exponent=65537,
    key_size=2048,
    backend=default_backend()
)

# Access the components of RSA private key
components = private_key.private_numbers()
n = components.public_numbers().n
d = components.d

print("Modulus (n):", n)
print("Private exponent (d):", d)