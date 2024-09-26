import ssl
import socket

# Create a context object with a custom verify callback
ctx = ssl.create_default_context()

# Set the hostname for the network connection
ctx.check_hostname = False  # 'example.com'

# Set the hostname for the certificate verification
ctx.verify_mode = ssl.CERT_REQUIRED
ctx.ca_certs = 'path/to/CA/certificate'

# Connect to the remote host
with ctx.wrap_socket(socket.socket(socket.AF_INET, socket.SOCK_STREAM), server_hostname='example.com') as s:
    s.connect(('example-proxy.com', 443))