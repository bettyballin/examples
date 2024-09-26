from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend
import hashlib

with open('pub_key.pem', 'rb') as key_file:
    public_key = serialization.load_pem_public_key(
        key_file.read(),
        backend=default_backend()
    )

pub_der = public_key.public_bytes(
    encoding=serialization.Encoding.DER,
    format=serialization.PublicFormat.PKCS1
)

print(hashlib.sha256(pub_der).hexdigest())