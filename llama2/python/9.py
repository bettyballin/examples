import OpenSSL.crypto

with open("certificate.p12", "rb") as f:
    p12 = OpenSSL.crypto.load_pkcs12(f.read())

# Extract the certificate from the PKCS#12 file
cert = p12.get_certificate()

# Print the subject and issuer of the certificate
print("Subject:", cert.get_subject())
print("Issuer:", cert.get_issuer())

# Check if the certificate is valid
try:
    OpenSSL.crypto.verify(cert, cert.get_signature_name(), cert.get_signature())
    print("Certificate is valid")
except OpenSSL.crypto.Error:
    print("Certificate is not valid")