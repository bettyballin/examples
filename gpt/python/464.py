
from cryptography import x509
from cryptography.hazmat.backends import default_backend

def extract_crl_version(crl_file_path):
    with open(crl_file_path, "rb") as file:
        crl_data = file.read()

    crl = x509.load_der_x509_crl(crl_data, default_backend())

    # `crl.version` is an enum, so we access the `value` attribute to get the integer value.
    # Subtracting 1 from the value since versions are zero-indexed in the enum (e.g., v2 is represented as 1).
    crl_version_number = crl.version.value - 1

   
