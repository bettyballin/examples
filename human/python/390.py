from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.serialization.pkcs12 import generate_pkcs12
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from cryptography.hazmat.backends import default_backend

key = serialization.load_pem_private_key(
    b"your_private_key_here",
    password=None,
    backend=default_backend()
)

cert1 = serialization.load_pem_certificate(
    b"your_cert1_here",
    backend=default_backend()
)

cert2 = serialization.load_pem_certificate(
    b"your_cert2_here",
    backend=default_backend()
)

pem_pkcs12 = generate_pkcs12(
    serialization.BestAvailableEncryption(b"somepassword"),
    key,
    [cert1, cert2]
)