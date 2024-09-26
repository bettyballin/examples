import cryptography.hazmat.primitives.asymmetric.ec as ec

private_key_hex = "your_private_key_here"
private_bytes = bytearray.fromhex(private_key_hex)

# Create a new ECDSA curve object with the secp256r1 (NIST P-256) parameters.
curve = ec.SECP384R1()

# Load private key from bytes
private_key = ec.derive_private_key(
    int.from_bytes(private_bytes, byteorder="big"), curve)