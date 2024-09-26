from OpenSSL import crypto

with open('path/to/your/certificate.p12', 'rb') as f:
    p12 = crypto.load_pkcs12(f.read(), b'your_password')