# Python 3.7 using Cryptography
from cryptography.hazmat.primitives import serialization, hashes
from cryptography.hazmat.backends import default_backend

with open('pub_key.pem', 'rb') as key_file: 
    public_key = serialization.load_pem_public_key(key_file.read(), backend=default_backend())

pub_der = public_key.public_bytes(
    encoding=serialization.Encoding.DER,
    format=serialization.PublicFormat.SubjectPublicKeyInfo,
)

digest = hashes.Hash(hashes.SHA1(), backend=default_backend())
digest.update(pub_der)
print(digest.finalize().hex())