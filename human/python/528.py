from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import ec
import base64

curve = ec.SECP256R1()

clientKey = 'zIhDVlFUpWQiRP+bjyEIhSLq8rcB8+XInXGhm6JGcVI='
privateKeyInt = int.from_bytes(base64.b64decode(clientKey), byteorder='big', signed=False)
privateKey = ec.derive_private_key(privateKeyInt, curve, default_backend())

serverPubKey = 'WIUBDotrk02Rk/apL11jQPbmX0quyaYz2EIkGUlVf7t2JnYJt9JTLkqvzY4h93gCO6yrYr7+SMZnvKZypXCfaQ=='
publicKeyUncomp = b'\x04' + base64.b64decode(serverPubKey)
publicKey = ec.EllipticCurvePublicKey.from_encoded_point(curve, publicKeyUncomp)

sharedSecret = privateKey.exchange(ec.ECDH(), publicKey)
print(base64.b64encode(sharedSecret).decode('utf8'))