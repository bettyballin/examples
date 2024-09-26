from cryptography import x509
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend

def extract_public_key(certificate):
    # Decode the certificate from PEM format
    cert = x509.load_pem_x509_certificate(certificate, backend=default_backend())

    # Extract the public key
    pubkey = cert.public_key()

    # Encode the public key as a DER byte string
    der_pubkey = pubkey.public_bytes(
        encoding=serialization.Encoding.DER,
        format=serialization.PublicFormat.SubjectPublicKeyInfo
    )

    return der_pubkey