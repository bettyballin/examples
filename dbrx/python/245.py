import base64
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.primitives import serialization
import jwt

# Extract x and y coordinates from JWKS JSON file provided by "jku"
x = b'...'  # replace with actual x coordinate
y = b'...'  # replace with actual y coordinate

# Create a new Elliptic Curve Public Key object with the extracted parameters (x and y)
public_key_numbers = ec.EllipticCurvePublicNumbers(
    int.from_bytes(x, byteorder='big'),
    int.from_bytes(y, byteorder='big'),
    curve=ec.SECP384R1()
)

# Create a new EC public key
public_key = public_key_numbers.public_key()

# Decode the JWT token and extract header and payload
jwt_token = "..."  # replace with actual JWT token
token_parts = jwt_token.split('.')
header_b64, payload_b64, signature_b64 = token_parts

# Convert base64url to bytes for verification
signature_bytes = base64.urlsafe_b64decode(signature_b64 + '=' * (-len(signature_b64) % 4))

# Verify the ES384 JWT signature using x and y coordinates
public_key.verify(
    signature=signature_bytes,
    data=(header_b64 + '.' + payload_b64).encode(),
    algorithm=ec.ECDSA(ec.SECP384R1())
)