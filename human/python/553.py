import socket
import ssl

tls_hostname = 'www.example.com'
context = ssl.create_default_context()

with socket.create_connection(('127.0.0.1',8443)) as sock:
    with context.wrap_socket(sock, server_hostname=tls_hostname) as ssock:
        print(sslsocket.version())

Note: `sslscket` instead of `ssock` and it should be `sslscket` is not defined in this code, it should be `ssock` with the correct method. Corrected code below.


import socket
import ssl

tls_hostname = 'www.example.com'
context = ssl.create_default_context()

with socket.create_connection(('127.0.0.1',8443)) as sock:
    with context.wrap_socket(sock, server_hostname=tls_hostname) as ssock:
        print(ssock.ssl_version)