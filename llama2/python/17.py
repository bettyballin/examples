import OpenSSL

# Create a RSA private key
key = OpenSSL.crypto.RSA.generate(1024)

# Create a certificate signing request (CSR)
csr = OpenSSL.crypto.X509Req()

# Set the CN (Common Name)
csr.get_subject().CN = "example.com"

# Set the key for the CSR
csr.set_pubkey(key)

# Sign the CSR with the private key
csr.sign(key, "sha256")

# Create a certificate
cert = OpenSSL.crypto.X509()

# Set the subject of the certificate
cert.set_subject(csr.get_subject())

# Set the issuer of the certificate
cert.set_issuer(csr.get_subject())

# Set the public key for the certificate
cert.set_pubkey(key)

# Set the serial number of the certificate
cert.set_serial_number(1)

# Set the not-before and not-after dates for the certificate
cert.gmtime_adj_notBefore(0)
cert.gmtime_adj_notAfter(365 * 24 * 60 * 60)

# Add an extension to the certificate
cert.add_extensions([OpenSSL.crypto.X509Extension(b"subjectAltName", False, b"DNS:example.com")])

# Sign the certificate with the private key
cert.sign(key, "sha256")

# Save the certificate and private key to files
OpenSSL.crypto.dump_certificate(OpenSSL.crypto.FILETYPE_PEM, cert)
OpenSSL.crypto.dump_privatekey(OpenSSL.crypto.FILETYPE_PEM, key)