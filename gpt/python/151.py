
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import dh
from cryptography.hazmat.primitives import serialization

# Parameters for Diffie-Hellman (typically you would use more than 2048 bits for the key size)
parameters = dh.generate_parameters(generator=2, key_size=2048, backend=default_backend())

# Generate a private key for use in the exchange.
private_key = parameters.generate_private_key()

# Public key that can be sent to the other party
public_key = private_key.public_key()

# In a
