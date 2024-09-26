import base64
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec

server_private_key = b'your_base64_encoded_server_private_key_here'

def compute_shared_secret(ephemeral_public_key: bytearray) -> bytes:
    client_public_key = serialization.load_der_public_key(ephemeral_public_key)
    server_private_key_loaded = serialization.load_der_private_key(
        base64.b64decode(server_private_key),
        password=None
    )
    shared_secret = server_private_key_loaded.exchange(ec.ECDH(), client_public_key)
    return shared_secret