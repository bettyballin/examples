import json
from socket import *
import time
import uuid
from Crypto.Random import get_random_bytes
from Crypto.Protocol.SecretSharing import Shamir
import base64

server = socket(AF_INET, SOCK_DGRAM)
server.setsockopt(SOL_SOCKET, SO_REUSEPORT, 1)
server.setsockopt(SOL_SOCKET, SO_BROADCAST, 1)

id = str(uuid.uuid4())

# generate 16-byte key
key = get_random_bytes(16)

# prepare k chunks of key
shares = Shamir.split(3, 5, key)

while True:
    for index, share in shares:
        message = {
            'id': id,
            'index': int(index),
            'share': base64.b64encode(share).decode('utf-8')
        }

        # send bytes
        server.sendto(json.dumps(message).encode(), ('255.255.255.255', 37020))

    time.sleep(1)