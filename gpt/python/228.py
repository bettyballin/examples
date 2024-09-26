
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import rsa

# Generate a new private key
private_key = rsa.generate_private_key(
    public_exponent=65537,
    key_size=2048,  # You can change the key size to 4096 for a stronger key
    backend=default_backend()
)

# Generate the public key
public_key = private_key.public_key()

# Now, you can use the private_key and public_key variables

