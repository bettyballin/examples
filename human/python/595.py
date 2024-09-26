from asn1crypto import cms, core
from cryptography import x509
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.exceptions import InvalidSignature
from datetime import datetime
import hashlib

class CustomError(Exception):
    pass

def validate_token_signature(
    trusted_cert: x509.Certificate,
    signature: bytes,
    payment_data: bytes,
    ephemeral_pub: bytes,
    transaction_id: bytes,
    application_data: bytes,
) -> None:
    signed_data = cms.ContentInfo.load(signature)['content']
    algo = signed_data['digest_algorithms'][0]['algorithm'].native
    signers_info = signed_data['signer_infos']
    attr_signature = signers_info[0].native['signature']
    attrs = signers_info[0]['signed_attrs']

    # Insure data signer and cert signer match
    cert_issuer: str = trusted_cert.issuer.rdns[0].rfc4514_string().split("=")[1]
    signed_data_issuer: str = dict(dict(dict(signers_info.native[0])['sid'])['issuer'])['common_name']
    if not cert_issuer == signed_data_issuer:
        raise CustomError('error')

    # Verify that cert is still validate now
    if not trusted_cert.not_valid_before < datetime.now() < trusted_cert.not_valid_after:
        raise CustomError('error')

    # user data
    udata: bytes = ephemeral_pub + payment_data + transaction_id + application_data

    mdData = getattr(hashlib, algo)(udata).digest()

    if attrs is not None and not isinstance(attrs, core.Void):
        # if attrs, mdSigned == message_digest attribute
        mdSigned = None
        for attr in attrs:
            if attr['type'].native == 'message_digest':
                mdSigned = attr['values'].native[0]
        signedData = attrs.dump()
        signedData = b'\x31' + signedData[1:]
    else:
        # if no attrs, mdSigned == hash of userdata
        mdSigned = mdData
        signedData = udata

    # 2- verify() must succeed succeeded
    try:
        trusted_cert.public_key().verify(attr_signature, signedData, ec.ECDSA(hashes.SHA256()))
    except InvalidSignature:
        raise CustomError('error')

    # 3- hashok must be True
    if not mdData == mdSigned:
        raise CustomError('error')