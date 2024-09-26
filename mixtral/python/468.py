from cryptography import x509
from cryptography.hazmat.backends import default_backend

def extract_crl_version(filepath):
    with open(filepath, "rb") as file:
        crl = x509.load_der_x509_crl(file.read(), backend=default_backend())

    version_extension = next((ext for ext in crl.extensions if ext.oid == x509.oid.ExtensionOID.CRL_NUMBER), None)

    return int(version_extension.value.crl_number)

crl_filepath = "path/to/your-crl"
print("CRL Version:", extract_crl_version(crl_filepath))