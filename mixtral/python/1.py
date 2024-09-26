from OpenSSL import crypto
import time

# Load PKCS #12 data
with open("your_certificate.p12", "rb") as fh:
    pkcs12 = crypto.load_pkcs12(fh.read(), b"password")

# Get the certificate
x509 = pkcs12.get_certificate()

# Print out some information
print("Subject:", x509.get_subject().CN)

# Check if it's valid
if not crypto._lib.X509_cmp_time(crypto._lib.ASN1_TIME_set(x509.get_notAfter()), 
                                crypto._lib.ASN1_TIME_set(time.gmtime())):
    print("Certificate is not valid.")
else:
    print("Certificate is still valid!")