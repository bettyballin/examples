
from asn1crypto import cms

def extract_signature_p7s(p7s_path):
    with open(p7s_path, 'rb') as file:
        p7s_data = file.read()
    
    p7s = cms.ContentInfo.load(p7s_data)
    signed_data = p7s['content']

    # Extract signatures (SignerInfo)
    signatures = signed_data['signer_infos']
    for signer_info in signatures:
        signature = signer_info['signature'].native
        print(f"Signature: {signature}")

    # To check if the payload is internal or external
    if signed_data['encap_content_info']['content'].native is None:
        print("The payload is external to the p7s file.")
    else:
