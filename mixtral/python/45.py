from OpenSSL import crypto

def extract_publickey(certstr, format='PEM'):
    cert = crypto.load_certificate(crypto.FILETYPE_PEM if format == 'PEM' else crypto.FILETYPE_ASN1, certstr)

    # Get the public key
    pubkey = cert.get_pubkey()

    return crypto.dump_publickey(crypto.FILETYPE_ASN1, pubkey).decode('utf-8')

# Example usage:
certstr = """-----BEGIN CERTIFICATE-----
... your certificate string here ...
-----END CERTIFICATE-----"""

print(extract_publickey(certstr))