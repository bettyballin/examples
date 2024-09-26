# Python 3.10 code to extract relevant data from a PKCS#7 signature file

from datetime import datetime
from asn1crypto import cms
from cryptography import x509
from cryptography.hazmat.primitives.serialization import pkcs7

def extract_data(p7s_filepath: str) -> dict:
    # these are the components we are going to extract
    payload: bytes                      # the original payload
    signature: bytes                    # the digital signature
    signature_algorithm: str            # the algorithm used to generate the signature
    signature_timestamp: datetime       # the signature's timestamp
    payload_hash: bytes                 # the payload hash
    hash_algorithm: str                 # the algorithm used to calculate the payload hash
    cert_chain: list[x509.Certificate]  # the X509 certificate chain

    # load the p7s file
    with open(p7s_filepath, 'rb') as f:
        p7s_bytes: bytes = f.read()

    # extract the certificater chain
    cert_chain = pkcs7.load_der_pkcs7_certificates(p7s_bytes)

    # extract the needed structures
    content_info: cms.ContentInfo = cms.ContentInfo.load(p7s_bytes)
    signed_data: cms.SignedData = content_info['content']
    signer_info: cms.SignerInfo = signed_data['signer_infos'][0]

    # extract the payload (None if payload is detached)
    payload = signed_data['encap_content_info']['content'].native

    # extract the remaining components
    signature = signer_info['signature'].native
    signature_algorithm = signer_info['signature_algorithm']['algorithm'].native
    hash_algorithm = signer_info['digest_algorithm']['algorithm'].native

    signed_attrs = signer_info['signed_attrs']
    for signed_attr in signed_attrs:
        match signed_attr['type'].native:
            case 'message_digest':
                payload_hash = signed_attr['values'][0].native
            case 'signing_time':
                signature_timestamp = datetime.strptime(signed_attr['values'][0].native, "%Y%m%d%H%M%S%z")

    return {
        'payload': payload,
        'signature': signature,
        'signature_algorithm': signature_algorithm,
        'signature_timestamp': signature_timestamp,
        'payload_hash': payload_hash,
        'hash_algorithm': hash_algorithm,
        'cert_chain': cert_chain
    }

if __name__ == "__main__":
    p7s_filepath: str = 'my_signature_file_path.p7s'
    extracted_data = extract_data(p7s_filepath)
    print(extracted_data)