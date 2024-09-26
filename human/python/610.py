import uuid
from Crypto.Random import get_random_bytes
from Crypto.Protocol.SecretSharing import Shamir

id_sender = uuid.uuid4()
key = get_random_bytes(16)
shares = Shamir.split(3, 5, key)

for index_sender, share_sender in shares:
    
    # Encode
    message = id_sender.bytes + index_sender.to_bytes(4, byteorder='big') + share_sender 

    # Send message via socket
    # message_sent = message  # Simulating sending and receiving

    # Decode  
    id_receiver = uuid.UUID(bytes=message[:16])
    index_receiver = int.from_bytes(message[16:20], byteorder='big')
    share_receiver = message[20:]

    print(id_sender == id_receiver, index_sender == index_receiver, share_sender == share_receiver) # True True True