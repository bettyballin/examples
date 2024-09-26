
from socket import *
import socket
import time
import uuid
from Crypto.Random import get_random_bytes
from Crypto.Protocol.SecretSharing import Shamir

server = socket.socket(AF_INET, SOCK_DGRAM)
server.setsockopt(SOL_SOCKET, SO_REUSEPORT, 1)
server.setsockopt(SOL_SOCKET, SO_BROADCAST, 1)

id = str(uuid.uuid4())

# generate 16-byte key
key = get_random_bytes(16)
# prepare k chunks of key
shares = Shamir.split(3, 5, key)

while True:
    for index, share in shares:
        share_in_hex = share.hex()  # Convert binary share to hex string for transmission
        message = f"{id}:{index}:{share_in_hex}".encode('utf-8')
        server.sendto(message, ('<broadcast>', 37020))
        print("message
