
import socket

# Save the original socket creation function
true_socket = socket.socket

# Define a new function that raises an exception
def no_network(*args, **kwargs):
    raise RuntimeError("Network access not allowed")

# Replace the socket creation function with your no-network function
socket.socket = no_network

# Now, any attempt to create a socket will fail
try:
    # This will raise an exception
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
except RuntimeError as e:
    print(e)  # prints "Network access not allowed"

