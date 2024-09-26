
import ssl
import socket
from urllib.parse import urlparse
import OpenSSL.crypto

# Custom method to verify the certificate's subjectAltName against the actual host
def verify_certificate(host, cert):
    # Convert the certificate to a X509 object
    x509 = OpenSSL.crypto.load_certificate(OpenSSL.crypto.FILETYPE_PEM, cert)
    san = ''
    for idx in range(x509.get_extension_count()):
        ext = x509.get_extension(idx)
        if 'subjectAltName' in str(ext.get_short_name()):
            san = str(ext)
            break
    
    # Check if the hostname is in the subjectAltName
    if 'DNS:{}'.format(host) in san:
        return True
    return False

# Define the host you want to connect to and the proxy hostname.
actual_host = 'example.com'
proxy_host = 'example-proxy.com'

# Create an SSLContext object and
