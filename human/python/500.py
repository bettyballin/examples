import socket

def get_remote_socket_info():
    # Create a socket object
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    # Get the remote socket information
    remote_socket_info = s.getpeername()

    # Print the remote socket information
    print(remote_socket_info)

    # Close the socket
    s.close()

get_remote_socket_info()