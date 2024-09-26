from cryptography import x509
from cryptography.hazmat.backends import default_backend

def load_cert(cert_path):
    with open(cert_path, 'rb') as f:
        cert_data = f.read()
    cert = x509.load_pem_x509_certificate(cert_data, default_backend())
    return cert

cert = load_cert('path_to_your_cert.pem')

sign = cert.signature_hash_algorithm
print(f"Signature Hash Algorithm: {sign}")

oid = cert.signature_algorithm_oid
print(f"OID: {oid}")