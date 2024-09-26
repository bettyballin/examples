import cms

def get_embedded_signature(p7s_file):
    content_info = cms.ContentInfo.load(open(p7s_file, 'rb').read())
    signed_data = content_info['content']
    signatures = signed_data['signer_infos']

    for signature in signatures:
        encrypted_digest = signature['encrypted_digest'].native
        return encrypted_digest

# Usage example
p7s_embedded_file_path = "path/to/your/embedded/p7s/file.p7s"
signature = get_embedded_signature(p7s_embedded_file_path)
print(f"Embedded signature: {signature}")