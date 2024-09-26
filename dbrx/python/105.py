import socket

def receive_data():
    # Create a TCP/IP server on localhost and port 12345.
    host = 'localhost'
    port = 12345

    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.bind((host, port))

    try:
        # Listen for incoming connections.
        sock.listen(1)

        while True:
            connection, client_address = sock.accept()
            try:
                data = b''
                while True:
                    chunk = connection.recv(1024)  # Receive up to 1024 bytes at a time.
                    if not chunk:
                        break
                    data += chunk

                print('Received %s' % repr(data.decode()))

            finally:
                connection.close()

    finally:
        sock.close()

# Call receive_data() in your script's main function or loop.

if __name__ == "__main__":
    while True:
        receive_data()