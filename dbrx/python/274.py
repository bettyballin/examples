from cryptography.hazmat.primitives.asymmetric import dh
from base64 import b64decode

# Inputs
server_pub_x = "WIUBDotrk02Rk/apL11jQPbmX0quyaYz2EIkGUlVf7s="
server_pub_y = "diZ2CbfSUy5Kr82OIfd4Ajusq2K+/kjGZ7ymcqVwn2k="

# Decode the base64-encoded public key components
decoded_x = b64decode(server_pub_x)
decoded_y = b64decode(server_pub_y)

# Create a Diffie-Hellman private key object with 2048-bit modulus size
private_key = dh.generate_private_key(dh.MODP_2048())

# Extract the shared secret from the public keys and our own private key
shared_secret = private_key.exchange(
    dh.DHPublicNumbers(decoded_x + decoded_y, dh.MODP_2048()).public_key()
)

# Encode the shared secret in base64
shared_secret_b64 = shared_secret.hex().encode()

print(shared_secret_b64)