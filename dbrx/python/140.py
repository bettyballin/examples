import ssl
import socket

context = ssl.create_default_context(ssl.Purpose.SERVER_AUTH)
context.check_hostname = True
context.verify_mode = ssl.CERT_REQUIRED
context.load_verify_locations('cert.pem')

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:
    with context.wrap_socket(sock, server_side=False) as ssock:
        ssock.connect(('localhost', 8443))

        # Handle client connection