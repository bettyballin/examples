from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.primitives.asymmetric import padding
import base64

data = b"demo data"
signature = b"demo signature"

public_key_base64 = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEWdp8GPcGqmhgzEFj9Z2nSpQVddayaPe4FMzqM9wib1+aHaaIzoHoLN9zW4K8y4SPykE3YVK3sVqW6Af0lfx3gg=="
public_key_bytes = base64.b64decode(public_key_base64)
apple_public_key = ec.EllipticCurvePublicKey.from_encoded_point(ec.SECP256R1(), public_key_bytes)

# Verify the signature
try:
    apple_public_key.verify(
        signature,
        data,
        ec.ECDSA(hashes.SHA256())
    )
except ValueError as e:
    print(f"Signature verification failed: {e}")
else:
    print("Signature verified successfully!")