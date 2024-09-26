from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.serialization import pkcs12
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography import x509
from cryptography.x509.oid import NameOID
from cryptography.hazmat.primitives import hashes

# Generate a private key
key = rsa.generate_private_key(
    public_exponent=65537,
    key_size=2048,
)

# Generate a certificate
csr = (
    x509.CertificateSigningRequestBuilder()
    .subject_name(x509.Name([x509.NameAttribute(NameOID.COMMON_NAME, "example.com")]))
    .sign(key, hashes.SHA256())
)
certificate = (
    x509.CertificateBuilder()
    .subject_name(csr.subject)
    .issuer_name(csr.subject)
    .public_key(csr.public_key())
    .serial_number(x509.random_serial_number())
    .not_valid_before(datetime.datetime.utcnow())
    .not_valid_after(datetime.datetime.utcnow() + datetime.timedelta(days=30))
    .add_extension(x509.SubjectAlternativeName([x509.DNSName("localhost")]), critical=False)
    .sign(key, hashes.SHA256())
)

password = "password123"

user_certificate_bytes = pkcs12.serialize_key_and_certificates(
    name=None,
    key=key,
    cert=certificate,
    cas=None,
    encryption_algorithm=serialization.BestAvailableEncryption(password.encode('utf-8')),
    cipher=serialization.Cipher.AES,
    bits=128
)