from cryptography import x509
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.exceptions import InvalidSignature

class CustomError(Exception):
    pass

def verify_root_ca_chain_of_trust(
    trusted_root_ca: x509.Certificate,
    intermediate_cert: x509.Certificate,
    leaf_cert: x509.Certificate
) -> None:
    try:
        # verify that the intermediate CA is signed by the Apple Root CA - G3
        trusted_pub = trusted_root_ca.public_key()
        trusted_pub.verify(
            intermediate_cert.signature,
            intermediate_cert.tbs_certificate_bytes,
            ec.ECDSA(hashes.SHA256())
        )
        # verify that the leaf certificate is signed by the intermediate CA
        trusted_intermediate_pub = intermediate_cert.public_key()
        trusted_intermediate_pub.verify(
            leaf_cert.signature,
            leaf_cert.tbs_certificate_bytes,
            ec.ECDSA(hashes.SHA256())
        )
    except TypeError as err:
        raise CustomError('error') from err
    except InvalidSignature as err:
        raise CustomError('invalid signature') from err