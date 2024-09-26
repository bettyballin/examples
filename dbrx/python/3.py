from cryptography import x509
from cryptography.hazmat.backends import default_backend

with open("certificate.p12", "rb") as f:
    p12 = x509.load_p12(f.read(), password=None, backend=default_backend())

cert = p12.get_certificate()
subject = cert.get_subject()

common_name = subject.commonName.decode('utf-8')