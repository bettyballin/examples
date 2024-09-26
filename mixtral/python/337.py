import socket

def check_port(addr):
    port = addr[1]

    if not 10000 <= port < 11000:
        return False

    return True

server = socket.socket()

# Bind to the localhost and a specific port
server_address = ('localhost', 12345)

try:
    server.bind(server_address)
except Exception as e:
    print("Bind failed: " + str(e))

server.listen(5)  # Listen for incoming connections

while True:
    try:
        client, addr = server.accept()

        if not check_port(addr):
            continue

        data = b"Hello from the other side!"  # Convert to bytes

        print("Sending message to: " + str(client))

        # Send a response
        client.sendall(data)
        client.close()  # Close the client socket

    except Exception as e:
        print('Error: ' + str(e))

server.close()