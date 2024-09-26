import json
from socket import *
from Crypto.Protocol.SecretSharing import Shamir
import base64

audienceSocket = socket(AF_INET, SOCK_DGRAM)
audienceSocket.setsockopt(SOL_SOCKET, SO_REUSEPORT, 1)
audienceSocket.bind(('', 37020))

receivedShares = {}

while True:
    # get data from sender
    data, address = audienceSocket.recvfrom(4096)

    message = json.loads(data.decode('utf-8'))

    id_ = message['id']
    index = int(message['index'])

    share = base64.b64decode(message['share'])