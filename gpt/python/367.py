
import socket

# Create a TCP/IP socket
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Bind the socket to the server address
server_address = ('localhost', 1080)
server_socket.bind(server_address)

# Listen for incoming connections
server_socket.listen(5)

while True:
    # Wait for a connection
    connection, client_address = server_socket.accept()
    try:
        # Check if the source port is within the allowed range
        if 10000 <= client_address[1] <= 11000:
            print(f"Connection from {client_address} accepted.")
            # Handle the connection
        else:
            print(f"Connection from {client_address} rejected.")
            # Close the connection
            connection.close()
    except Exception as e:
        print(f
