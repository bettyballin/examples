from cryptography import x509
from cryptography.hazmat.backends import default_backend

# Load the certificate (replace with your own certificate data)
cert_data = b"your_certificate_data_here"

# Load the certificate
cert = x509.load_der_x509_certificate(cert_data, default_backend())

# Get the subject
subject = cert.subject

# Get the attributes for the country name OID
attributes = subject.get_attributes_for_oid(x509.NameOID.COUNTRY_NAME)

# Print the attribute values
for attribute in attributes:
    print(attribute.value)