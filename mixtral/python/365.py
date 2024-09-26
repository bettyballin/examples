from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import padding

public_key.verify(
    signature_decode,
    input_string.encode(),
    padding.Pkcs1v15(),
    hashes.SHA256()
)