from cryptography import x509
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization

# Generate a private key for demonstration purposes
from cryptography.hazmat.primitives.asymmetric import rsa
private_key = rsa.generate_private_key(
    public_exponent=65537,
    key_size=2048,
    backend=default_backend()
)

# Get the private bytes
private_bytes = private_key.private_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PrivateFormat.TraditionalOpenSSL,
    encryption_algorithm=serialization.NoEncryption()
)

# Generate a certificate signing request (CSR)
csr = x509.CertificateSigningRequestBuilder().subject_name(x509.Name([
    x509.NameAttribute(x509.NameOID.COUNTRY_NAME, u"US"),
    x509.NameAttribute(x509.NameOID.STATE_OR_PROVINCE_NAME, u"California"),
    x509.NameAttribute(x509.NameOID.LOCALITY_NAME, u"San Francisco"),
    x509.NameAttribute(x509.NameOID.ORGANIZATION_NAME, u"My Company"),
    x509.NameAttribute(x509.NameOID.COMMON_NAME, u"mysite.com"),
])).sign(private_key, hashes.SHA256(), default_backend())

# Generate a certificate
subject = issuer = x509.Name([
    x509.NameAttribute(x509.NameOID.COUNTRY_NAME, u"US"),
    x509.NameAttribute(x509.NameOID.STATE_OR_PROVINCE_NAME, u"California"),
    x509.NameAttribute(x509.NameOID.LOCALITY_NAME, u"San Francisco"),
    x509.NameAttribute(x509.NameOID.ORGANIZATION_NAME, u"My Company"),
    x509.NameAttribute(x509.NameOID.COMMON_NAME, u"mysite.com"),
])
cert = x509.CertificateBuilder().subject_name(
    subject
).issuer_name(
    issuer
).public_key(
    private_key.public_key()
).serial_number(
    x509.random_serial_number()
).not_valid_before(
    datetime.datetime.utcnow()
).not_valid_after(
    datetime.datetime.utcnow() + datetime.timedelta(days=10)
).add_extension(
    x509.SubjectAlternativeName([x509.DNSName(u"localhost")]),
    critical=False,
).sign(private_key, hashes.SHA256(), default_backend())

# Get the certificate public key
key = cert.public_key()

public_key = x509.load_der_x509_certificate(
    cert.public_bytes(serialization.Encoding.DER),
    default_backend()
).public_key()