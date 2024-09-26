from cryptography import x509
from cryptography.x509 import ExtensionOID
from cryptography.hazmat.backends import default_backend

# Load CRL data from a file
with open("path_to_your_crl_file.crl", "rb") as f:
    crl_data = f.read()

# Load CRL
crl = x509.load_der_x509_crl(crl_data, default_backend())

# Get the extension for OID 'CRL_Number'
extension = crl.extensions.get_extension_for_oid(ExtensionOID.CRL_NUMBER)

# Access the integer value of CRL Number using `crl_number` attribute
crl_number_int = int(extension.value.crl_number)
print(crl_number_int)  # Output: 17