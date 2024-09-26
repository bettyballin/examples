import base64
from cryptography import x509
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec, padding
from cryptography.hazmat.primitives import hashes

def compute_shared_secret(ephemeral_public_key):
    # Decode the base64 data
    key = base64.b64decode(ephemeral_public_key)

    # Load it as an X509 certificate
    cert = x509.load_pem_x509_certificate(key, default_backend())

    # Extract the Public Key from that Certificate
    public_key = cert.public_key()

    # Load server private key
    with open('path/to/your/server-priv.pem', 'rb') as key_file:
        private_key = serialization.load_pem_private_key(
            key_file.read(),
            password=None,
            backend=default_backend()
        )

    # Compute shared secret
    shared_secret = private_key.exchange(ec.ECDH(), public_key)

    return shared_secret