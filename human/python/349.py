from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.backends import default_backend

key = rsa.generate_private_key(
    public_exponent=65537,
    key_size=256,
    backend=default_backend()
)

private_bytes = key.private_numbers().private_value.to_bytes(32, 'big')
print(private_bytes)

private_hex = private_bytes.hex()
print(private_hex)