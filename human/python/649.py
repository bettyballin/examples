from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.serialization import PrivateFormat, Encoding
from cryptography.hazmat.primitives.serialization.pkcs12 import PBES

encryption = (
    PrivateFormat.PKCS12.encryption_builder().
    kdf_rounds(50000).
    key_cert_algorithm(PBES.PBESv1SHA1And3KeyTripleDESCBC).
    hmac_hash(hashes.SHA1()).build(b"my password")
)