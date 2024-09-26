
from cryptography import x509
from cryptography.hazmat.backends import default_backend

# Load the certificate
path = "mycert.crt"
with open(path, 'rb') as cert_file:
    data = cert_file.read()
cert = x509.load_pem_x509_certificate(data, default_backend())

# Retrieve the issuer attributes
issuer = cert.issuer

# Define the OIDs for the attributes you want to retrieve
oid_country_name = x509.NameOID.COUNTRY_NAME
oid_organization_name = x509.NameOID.ORGANIZATION_NAME
oid_organizational_unit_name = x509.NameOID.ORGANIZATIONAL_UNIT_NAME
oid_common_name = x509
