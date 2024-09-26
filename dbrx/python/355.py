from cryptography.hazmat.primitives import serialization
from cryptography.x509.oid import ExtensionOID, CRLEntryExtensionOID

def extract_crl_version(crl_file_path):
    with open(crl_file_path, "rb") as file:
        crl_data = file.read()

    # Load the CRL data using OpenSSL backend.
    openssl_backend = serialization.DefaultBackend()
    x509_crl_obj = openssl_backend.load_x509_crl(crl_data)

    # Extract version number from X509_CRL object.
    if hasattr(x509_crl_obj, "version"):
        crl_version = int.from_bytes(x509_crl_obj.version.to_bytes(1, byteorder="big"))
    else:
        raise AttributeError("X509_CRL object does not have a 'version' attribute.")

    return crl_version

crl_file_path = "path/to/crl.der"
crl_version = extract_crl_version(crl_file_path)
print(f"CRL Version: {crl_version}")