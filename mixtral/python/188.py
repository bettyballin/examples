import socket
import ssl

# Server side
context = ssl.SSLContext(ssl.PROTOCOL_TLS)
context.load_cert_chain('server-certfile', 'server-keyfile')

with socket.socket() as sock:
    # Bind the socket
    server_address = ('localhost', 12345)
    print("Starting up on {} port {}".format(*server_address))

    sock.bind(server_address)

    with context.wrap_socket(sock, server_side=True) as ssock:
        # Listen for incoming connections
        ssock.listen()
        while True:
            connection, client_address = ssock.accept()
            try:
                print("Connection from {}".format(client_address))
                connection.close()
            except:
                print("Error occurred")

# Client side
host = 'localhost'
port = 12345
with socket.create_connection((host, port)) as sock:
    with context.wrap_socket(sock, server_hostname=host) as ssock:
        print("Connected to {}".format(ssock.getpeername()))