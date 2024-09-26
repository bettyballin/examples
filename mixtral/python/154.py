from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import dh

# Alice generates her DH parameters
parameters = dh.generate_parameters(generator=2, key_size=2048, backend=default_backend())
alice_private = parameters.generate_private_key()

# Bob does the same
bob_private = parameters.generate_private_key()

# Alice generates her public key
alice_public = alice_private.public_key()

# Bob generates his public key
bob_public = bob_private.public_key()

# Alice and Bob exchange their public keys
alice_shared = alice_private.exchange(bob_public)
bob_shared = bob_private.exchange(alice_public)

# The shared keys should be the same
print(alice_shared == bob_shared)