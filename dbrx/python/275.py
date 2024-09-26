from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend

# assuming public_key is loaded and input_string, signature_decoded are defined
public_key.verify(
    signature_decoded,
    str.encode(input_string),
    padding.PKCS1v15(),
    hashes.SHA256()
)