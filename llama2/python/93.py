import cryptography
from cryptography.hazmat.backends import default_backend
import ssl
import socket

# define variables
keyname = 'path/to/encrypted/key'
certname = 'path/to/certificate'
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Load the encrypted private key from file
with open(keyname, "rb") as f:
    encrypted_key = f.read()

# Decrypt the private key using the password
private_key = cryptography.hazmat.primitives.serialization.load_pem_private_key(
    encrypted_key,
    password=b"passphrase",
    backend=default_backend()
)

# Now you can use the decrypted private key and certificate to wrap the socket
ssl_context = ssl.create_default_context(ssl.Purpose.CLIENT_AUTH)
ssl_context.load_cert_chain(certname, private_key)

wrapped_socket = ssl_context.wrap_socket(sock, server_side=True)