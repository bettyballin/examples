
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import ec
import base64

# Replace these with actual data and signature
data = b"actual data to be verified"
signature_base64 = "actual_base64_encoded_signature"
public_key_base64 = "actual_base64_encoded_public_key"

# Decode the base64 encoded signature and public key
signature = base64.b64decode(signature_base64)
public_key_bytes = base64.b64decode(public_key_base64)

# Load the public key
public_key = ec.EllipticCurvePublicKey.from_encoded_point(ec.SECP256R1(), public_key
