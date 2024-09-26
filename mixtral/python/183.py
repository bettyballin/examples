import ssl
import socket

context = ssl.SSLContext(ssl.PROTOCOL_TLSv1_2)
context.check_hostname = False
context.verify_mode = ssl.CERT_NONE

# Load the certificate and private key
with open("cert.pem", "rb") as f:
    certfile = f.read()
with open("key.pem", "rb") as f:
    private_key = f.read()

context.load_cert_chain(certfile, private_key)

# Create a socket
your_socket = socket.socket(socket.AF_INET)

# Wrap your socket with SSL
wrapped_socket = context.wrap_socket(your_socket, server_side=True)

# Listen for incoming connections
wrapped_socket.bind(("localhost", 8080))
wrapped_socket.listen(5)

# Accept incoming connections
conn, addr = wrapped_socket.accept()