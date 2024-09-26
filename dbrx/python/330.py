from asn1crypto import cms

def get_signature(p7s_file):
    with open(p7s_file, 'rb') as file:
        content_info = cms.ContentInfo.load(file.read())
    signed_data = content_info['content']
    signatures = signed_data['signer_infos']

    for signature in signatures:
        encrypted_digest = signature['encrypted_digest'].native
        return encrypted_digest

# Usage example
p7s_file_path = "path/to/your/p7s/file.p7s"
signature = get_signature(p7s_file_path)
print(f"Signature: {signature}")