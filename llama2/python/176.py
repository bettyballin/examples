import base64
from cryptography import x509
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import hashes
from OpenSSL import crypto

def verify_pkcs7(signature, data, cert_pem):
    # Load the certificate
    cert = crypto.load_certificate(crypto.FILETYPE_PEM, cert_pem)

    # Create a PKCS#7 object
    p7 = crypto.PKCS7_signature(crypto.FILETYPE_PEM, signature)

    # Verify the signature
    crypto.verify(p7, data, cert, [], [])

    return True

# Load the certificate and private key
cert_pem = b'''
-----BEGIN CERTIFICATE-----
... your certificate here ...
-----END CERTIFICATE-----
'''

data = b'Hello, world!'
signature = b'... your signature here ...'

verified = verify_pkcs7(signature, data, cert_pem)

if verified:
    print("Signature verified successfully")
else:
    print("Signature verification failed")