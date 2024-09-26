from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import rsa
import jose
import json

# Generate RSA key pair
private_key = rsa.generate_private_key(
    public_exponent=65537,
    key_size=2048,
    backend=default_backend()
)
public_key = private_key.public_key().public_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PublicFormat.SubjectPublicKeyInfo
).decode('utf-8')

# Create JWK with kid and use
jwk_private = jose.JWKRSA(key=private_key)
jwk_public = jose.JWKRSA(key=public_key, alg="RS256", key_id='my-custom-kid', use='sig')

# Print JWKS
print("Private Key:")
print(json.dumps({'keys': [jwk_private]}, indent=4))

print("\nPublic Key:")
print(json.dumps({'keys': [jwk_public]}, indent=4))