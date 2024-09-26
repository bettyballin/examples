
from M2Crypto import X509, Err

def load_certificates(cert_files):
    certs = []
    for cert_file in cert_files:
        with open(cert_file, 'rb') as f:
            cert_data = f.read()
            cert = X509.load_cert_string(cert_data, X509.FORMAT_PEM)
            certs.append(cert)
    return certs

def verify_cert_chain(cert_chain, trusted_certs):
    store = X509.X509_Store()
    for trusted_cert in trusted_certs:
        store.add_cert(trusted_cert)

    store_ctx = X509.X509_Store_Context(store)

    for i in range(len(cert_chain) - 1, 0, -1):
        store_ctx.set_cert(cert_chain[i])
        store_ctx.set_chain(X509.X509_Stack())
        store_ctx.add_cert(cert_chain[i-1])

        try:
            if not store_ctx.verify_certificate():
               
