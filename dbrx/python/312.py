from pyasn1.codec.der.decoder import decode as der_decode
from cryptography import x509
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.exceptions import InvalidSignature
from base64 import b64decode
from binascii import unhexlify

def get_cms_signing_time(p7: bytes):
    from OpenSSL import crypto
    from cryptography.hazmat.backends import default_backend
    cms = crypto.load_pkcs7_data(crypto.FILETYPE_ASN1, p7)
    signing_time = None
    for signer in cms.get_signers():
        for attr in signer.get_signed_attributes():
            if attr.get_short_name() == 'signingTime':
                signing_time = attr.get_data()
                break
    if signing_time is None:
        raise ValueError("No signing time found")
    return signing_time

def validate_token_signature(
    trusted_cert: x509.Certificate,
    signature: str,
    payment_data: str,
    ephemeral_pub: str,
    transaction_id: str,
    application_data: str = None) -> None:
    data_byte: bytes = b64decode(ephemeral_pub)
    payment_data_byte: bytes = b64decode(payment_data)
    transaction_id_byte: bytes = unhexlify(transaction_id)

    if application_data is not None:
        application_data_byte: bytes = b64decode(application_data)
        
    data: bytes = b''.join([data_byte, payment_data_byte, transaction_id_byte])
    
    try:
        trusted_leaf_pub = trusted_cert.public_key()
        # Verify the signature was created using the private key corresponding to the leaf certificate
        if not trusted_leaf_pub.verify(b64decode(signature), data, ec.ECDSA(hashes.SHA256())):
            raise InvalidSignature('error')
        
        # Assuming p7 is defined somewhere, passing it to the function
        p7 = b''  # Replace with actual p7 data
        cms_signing_time = get_cms_signing_time(p7)
        # Compare CMS signing time with transaction time
        
    except InvalidSignature as err:
        print(err)  # or handle the error appropriately