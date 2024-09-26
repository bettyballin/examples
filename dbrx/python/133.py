import ssl
import io
import socket

# Assuming cert_str and priv_key_str are the contents of 'cert.pem' and 'key.pem'
cert_str = """-----BEGIN CERTIFICATE-----
... your certificate content ...
-----END CERTIFICATE-----"""

priv_key_str = """-----BEGIN PRIVATE KEY-----
... your private key content ...
-----END PRIVATE KEY-----"""

context = ssl.create_default_context(ssl.Purpose.CLIENT_AUTH)
context.load_cert_chain(certfile=io.StringIO(cert_str), keyfile=io.StringIO(priv_key_str))

server_socket = socket.socket(socket.AF_INET)
server_socket.bind(('localhost', 443))
server_socket.listen(5)

wrapped_socket = context.wrap_socket(server_socket, server_side=True)

# Now you can use wrapped_socket as a regular socket