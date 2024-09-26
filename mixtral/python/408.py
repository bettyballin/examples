from cryptography import x509
import base64
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec

# Example usage:
if __name__ == "__main__":
    # Generate a private key
    private_key = ec.generate_private_key(ec.SECP256R1(), default_backend())

    # Get the private bytes
    private_bytes = private_key.private_bytes(
        encoding=serialization.Encoding.PEM,
        format=serialization.PrivateFormat.TraditionalOpenSSL,
        encryption_algorithm=serialization.NoEncryption()
    )

    # Generate a certificate
    certificate = (
        x509.CertificateBuilder()
        .subject_name(x509.Name([x509.NameAttribute(NameOID.COMMON_NAME, "example.com")]))
        .issuer_name(x509.Name([x509.NameAttribute(NameOID.COMMON_NAME, "example.com")]))
        .public_key(private_key.public_key())
        .serial_number(x509.random_serial_number())
        .not_valid_before(datetime.datetime.utcnow())
        .not_valid_after(datetime.datetime.utcnow() + datetime.timedelta(days=30))
        .sign(private_key, hashes.SHA256(), default_backend())
    )

    # Get the certificate bytes
    certificate_bytes = certificate.public_bytes(serialization.Encoding.PEM)

    # Print the private key and certificate
    print(private_bytes.decode())
    print(certificate_bytes.decode())