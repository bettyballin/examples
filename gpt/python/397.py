
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.primitives import serialization
from jose import jwk
import json
import hashlib
from jose.constants import ALGORITHMS

# Generate RSA key pair
key = rsa.generate_private_key(
    public_exponent=65537,
    key_size=2048
)

# Convert private key to JWK format
private_key_jwk = jwk.construct(key, algorithm=ALGORITHMS.RS256).to_dict()

# Generate a Key ID (kid) for the JWK
# You can use a portion of the SHA-256 hash of the public key as the kid
public_key_der = key.public_key().public_bytes(
    encoding=serialization.Encoding.DER,
    format=serialization.PublicFormat.SubjectPublicKeyInfo
)
kid = hashlib.sha
