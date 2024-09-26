from cryptography import x509
from cryptography.hazmat.backends import default_backend

default_backend = default_backend()

crl_file = "path_to/some_crl_file.crl"

with open(crl_file, "rb") as f:
    crl_data = f.read()

crl = x509.load_pem_x509_crl(crl_data, default_backend)