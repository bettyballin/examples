import cryptography.hazmat.primitives.asymmetric.ec as ec

public_key_hex = "your_public_key_here"
public_bytes = bytearray.fromhex(public_key_hex)

# Create a new ECDSA curve object with the secp256r1 (NIST P-256) parameters.
curve = ec.SECP384R1()

# Load public key from bytes
public_key = ec.EllipticCurvePublicKey.from_encoded_point(
    curve,
    public_bytes
)

# Print the loaded public key
print(public_key)