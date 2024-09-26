from cryptography import x509
from cryptography.x509.oid import ExtensionOID

# assuming crl is a bytes object containing the CRL data
crl = x509.load_der_x509_crl(b'your_crl_data_here')

int_crl_number = int(crl.extensions.get_extension_for_oid(ExtensionOID.CRL_NUMBER).value)