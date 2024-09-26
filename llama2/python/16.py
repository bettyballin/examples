import cryptography
from cryptography import x509
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa

# Generate private key
private_key = rsa.generate_private_key(
    public_exponent=65537,
    key_size=2048,
    backend=default_backend()
)

# Generate certificate
subject = x509.Name([
    x509.NameAttribute(x509.NameOID.COMMON_NAME, u"example.com")
])
certificate = (
    x509.CertificateBuilder()
    .subject_name(subject)
    .issuer_name(subject)
    .public_key(private_key.public_key())
    .serial_number(x509.random_serial_number())
    .not_valid_before(datetime.datetime.utcnow())
    .not_valid_after(datetime.datetime.utcnow() + datetime.timedelta(days=365))
    .add_extension(x509.SubjectAlternativeName([x509.DNSName(u"localhost")]), critical=False)
    .sign(private_key, hashes.SHA256(), default_backend())
)

# Load certificate and private key
p12 = serialization.PrivateKeyInfo(private_key.private_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PrivateFormat.PKCS8,
    encryption_algorithm=serialization.NoEncryption()
))

# Export p12
with open('container.pfx', 'wb') as f:
    f.write(p12.export(file('container.pfx', 'wb'), include_private=True))