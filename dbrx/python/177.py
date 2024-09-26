from cryptography.hazmat.primitives import serialization
from OpenSSL import crypto

private_key = ...  # load your private key
certificate_chain = ...  # load your certificate chain

# Convert the Cryptography objects into PyOpenSSL ones.
pkey = crypto.PKey()
pkey.assign(crypto.load_privatekey(crypto.FILETYPE_PEM, private_key.private_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PrivateFormat.TraditionalOpenSSL,
    encryption_algorithm=serialization.NoEncryption())))

x509_chain = []
for cert in certificate_chain:
    x509_cert = crypto.X509.from_cryptography(cert)
    if not x509_chain:
        # The first element of the chain is our actual leaf certificate.
        pkey.assign(x509_cert.get_pubkey())
    
    x509_chain.append(x509_cert)

# Write out a PKCS12 file containing both private key and certificates
with open('myIdentity.p12', 'wb') as f:
    pkcs12 = crypto.PKCS12()
    pkcs12.set_privatekey(pkey)
    for cert in x509_chain:
        pkcs12.add_certificate(cert)

    # Set a password if you want to protect the private key.
    f.write(pkcs12.export(passphrase=b'my_password'))