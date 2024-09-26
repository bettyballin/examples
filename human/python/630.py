from cryptography import x509
from cryptography.x509.oid import ExtensionOID

# Load CRL data (replace with your own CRL data)
crl_data = b'your_crl_data_here'

# Load CRL
crl = x509.load_der_x509_crl(crl_data)

# Print CRL number
print(crl.extensions.get_extension_for_oid(ExtensionOID.CRL_NUMBER).value.crl_number)