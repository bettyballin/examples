
from cryptography import x509
from cryptography.hazmat.backends import default_backend
from cryptography.x509.oid import ExtensionOID

# Need to set default backend for cryptography as our version is low:
default_backend = default_backend()

crl_file = 'path_to/some_crl_file.crl'

# Load the CRL
with open(crl_file, 'rb') as f:
    crl_data = f.read()
    crl = x509.load_pem_x509_crl(crl_data, default_backend)

# Get the CRL Number extension
crl_number_extension = crl.extensions.get_extension_for_oid(ExtensionOID.CRL_NUMBER)

# Access the crl_number attribute to get the integer value
crl_number_value = crl_number_extension.value.crl_number

print(crl_number_value)

