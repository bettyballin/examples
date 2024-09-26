from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend
import base64

# Convert the private key from hex to bytes
private_key_hex = "63bd3b01c5ce749d87f5f7481232a93540acdb0f7b5c014ecd9cd32b041d6f33"
private_key_bytes = bytearray.fromhex(private_key_hex)

# Convert the public key from hex to bytes
public_key_hex = "04017655e42a892cc71bccedcb1cd421d03530e1d7edb52cef143c5562c4c6f0129fa5a37738013e64a1ff0e6cb7068815a13000eb162cb7a0214dfcf3c8fa101c"
public_key_bytes = bytearray.fromhex(public_key_hex)

# Load the private key
private_key = ec.derive_private_key(int.from_bytes(private_key_bytes, 'big'), ec.SECP256R1(), default_backend())

# Create a new public key object from the raw bytes
public_numbers = ec.EllipticCurvePublicNumbers.from_encoded_point(ec.SECP256R1(), public_key_bytes)
public_key = public_numbers.public_key(default_backend())

# Now you can use `private_key` and `public_key` for signing operations.

# Example usage:
signature = private_key.sign(b"Hello, World!")
print(signature)

try:
    public_key.verify(signature, b"Hello, World!")
    print("Signature verified successfully")
except:
    print("Signature verification failed")