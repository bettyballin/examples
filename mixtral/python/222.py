from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa

def gen_key():
    return rsa.generate_private_key(
        public_exponent=65537,
        key_size=2048,
    )

private_key = gen_key()
raw_bytes = private_key.private_bytes(
    encoding=serialization.Encoding.DER,
    format=serialization.PrivateFormat.Raw,
    encryption_algorithm=serialization.NoEncryption()
)
hexadecimal_representation = raw_bytes.hex()
print(hexadecimal_representation)