
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.serialization import Encoding, PublicFormat
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.primitives import serialization
import base64

# Inputs
server_pub_x_b64 = "WIUBDotrk02Rk/apL11jQPbmX0quyaYz2EIkGUlVf7s="
server_pub_y_b64 = "diZ2CbfSUy5Kr82OIfd4Ajusq2K+/kjGZ7ymcqVwn2k="

# Decode the public keys from Base64 to bytes
server_pub_x = base
