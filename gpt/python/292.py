
from OpenSSL import crypto
from cryptography import x509
from cryptography.hazmat.primitives import serialization

# Assume privateKey and certificate are already generated using cryptography
# e.g., privateKey = your_private_key, certificate = your_certificate

# Convert the cryptography objects to PyOpenSSL objects
pkey = crypto.load_privatekey(
    crypto.FILETYPE_PEM,
    privateKey.private_bytes(
        encoding=serialization.Encoding.PEM,
        format=serialization.PrivateFormat.TraditionalOpenSSL,
        encryption_algorithm=serialization.NoEncryption()
    )
)

cert = crypto.load_certificate(
    crypto.FILETYPE_PEM,
    certificate.public_bytes(serialization.Encoding.PEM)
)

# Create a PKCS#12 object
pkcs12 = crypto.PKCS12()

# Set the private key
