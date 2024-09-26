from cryptography import x509
from cryptography.x509.oid import ExtensionOID

crl = x509.load_der_x509_crl(b'your_crl_data_here')
extension = crl.extensions.get_extension_for_oid(ExtensionOID.CRL_NUMBER).value