from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import ec
from base64 import urlsafe_b64decode as base64url_decode

key = {
    'crv': 256,
    'x': 'your_x_value_here',
    'y': 'your_y_value_here'
}

curve = getattr(ec, "SECP" + str(key["crv"]))
numbers = ec.EllipticCurvePublicNumbers(
    curve=curve,
    x=int.from_bytes(base64url_decode(key['x']), 'big'),
    y=int.from_bytes(base64url_decode(key['y']), 'big')
)
public_key = numbers.public_key(default_backend())