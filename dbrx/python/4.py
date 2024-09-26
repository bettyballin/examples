from cryptography import crypto
from cryptography.x509 import load_pem_x509_csr
from cryptography.hazmat.backends import default_backend
from cryptography.x509.oid import NameOID

ca_bundle_path = 'path/to/your/ca-bundle.crt'
p12 = crypto.load_pkcs12(open('path/to/your/certificate.p12', 'rb').read())

with open(ca_bundle_path, 'rb') as f:
    ca_certificates = crypto.load_certificate(crypto.FILETYPE_PEM, f.read())

store = crypto.X509Store()
store.add_cert(ca_certificates)

store_ctx = crypto.X509StoreContext(store, p12.get_certificate())
try:
    store_ctx.verify_certificate()
except crypto.X509StoreContextError as e:
    print(f'Certificate validation failed: {e}')
else:
    print('Certificate is valid')