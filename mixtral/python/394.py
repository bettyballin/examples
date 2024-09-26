import hashlib
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend

# Generate a private key for demonstration purposes
from cryptography.hazmat.primitives.asymmetric import rsa
privKey = rsa.generate_private_key(
    public_exponent=65537,
    key_size=2048,
    backend=default_backend()
)

msg = b'\x15\x00\xea'
digest = hashlib.sha256(msg).digest()

# Convert the digest to big-endian
big_endian_digest = int.from_bytes(digest, byteorder='little').to_bytes((len(digest) + 7) // 8, 'big')

# Sign the digest
signature = privKey.sign(
    big_endian_digest,
    padding.PSS(
        mgf=padding.MGF1(hashes.SHA256()),
        salt_length=padding.PSS.MAX_LENGTH
    ),
    hashes.SHA256()
)