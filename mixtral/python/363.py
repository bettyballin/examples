import base64
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend

serverPubX = "your_serverPubX_value_here"
serverPubY = "your_serverPubY_value_here"

server_pubX = base64.b64decode(serverPubX)
server_pubY = base64.b64decode(serverPubY)

# Combine X and Y
server_public_key = ec.EllipticCurvePublicKey.from_encoded_point(
    ec.SECP256R1(),
    b'\x04' + server_pubX + server_pubY,
    default_backend()
)