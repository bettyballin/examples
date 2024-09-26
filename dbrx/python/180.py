from cryptography import x509
from cryptography.hazmat.backends import default_backend

path = "mycert.crt"
with open(path, 'rb') as cert_file:
    data = cert_file.read()
cert = x509.load_pem_x509_certificate(data, default_backend())
sign = str(cert.signature_algorithm_oid)
iss = cert.issuer
attributes = iss.get_attributes_for_oid(x509.NameOID.COMMON_NAME)

for attribute in attributes:
    print(attribute.value)