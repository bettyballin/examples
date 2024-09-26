from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.primitives import serialization

curve = ec.SECP256R1()
peer_private_key = ec.generate_private_key(curve)
peer_public_key = peer_private_key.public_key()

# Get the public key in uncompressed format (which includes both x and y) 
public_bytes = peer_public_key.public_bytes(
    encoding=serialization.Encoding.DER, 
    format=serialization.PublicFormat.UncompressedPoint
)

# Extract just the x-coordinate value from the byte string which should be 32 bytes long.
x_coordinate = public_bytes[1:33]

# When receiving a server's ECDH Public Key Value via Scapy or Wireshark as an encoded point
data_from_wireshark = b'...' # replace with actual data

# Decode it first before creating EllipticCurvePublicKey object
srv_public_key = ec.EllipticCurvePublicKey.from_encoded_point(curve, data_from_wireshark)