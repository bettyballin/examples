from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import ec
import base64

# Sample data and signature from Apple's documentation
data = b"This is some sample data."
signature_base64 = "MEUCIQD1pK/JvZjR0+lkqXVH5Ot2nNcwLGyzPmhYo8dT3W7Ce9E="

# Apple's public key from their documentation
public_key_base64 = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEWdp8GPcGqmhgzEFj9Z2nSpQVddayaPe4FMzqM9wiib1+aHaai6oHoLN9zW4K8y4SPykE3YVK3sVqW6Af0lfx3gg=="

# Decode the base64 encoded public key and signature
public_key_bytes = base64.b64decode(public_key_base64)
signature_der = base64.b64decode(signature_base64)

# Create an ECDSA verifier using Apple's public key
apple_public_key = ec.EllipticCurvePublicKey.from_encoded_point(ec.SECP256R1(), public_key_bytes[1:])
verifier = apple_public_key.verifier(signature_der, ec.ECDSA(hashes.SHA256()))

# Verify the signature
try:
    verifier.update(data)
    verifier.verify()
    print("Signature is valid")
except:
    print("Signature is not valid")