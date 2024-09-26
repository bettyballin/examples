import ssl
import socket

context = ssl.create_default_context()
# Set up our CA certificates for verifying the server's identity.
context.load_verify_locations(cafile='path/to/ca/certificates.pem')

def verify_callback(cert, hostname):
    # Implement your custom verification logic here. For example
    # you could check if 'example.com' is present in SANs of cert
    return True

# Set up our SNI and certificate name.
context.check_hostname = False
context.verify_mode = ssl.CERT_NONE

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    with context.wrap_socket(s, server_hostname='example.com') as ssl_sock:
        # Connect to the proxy IP address here instead of 'example.com'.
        ssl_sock.connect(('proxy_ip_address', 443))