from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.primitives.asymmetric.utils import encode_dss_signature
from cryptography.hazmat.primitives.serialization import load_der_public_key
from cryptography.hazmat.primitives import hashes
from cryptography.exceptions import InvalidSignature
import base64
import json

publikKeyDer = base64.b64decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEWzC5lPNifcHNuKL+/jjhrtTi+9gAMbYui9Vv7TjtS7RCt8p6Y6zUmHVpGEowuVMuOSNxfpJYpnGExNT/eWhuwQ==")
data = {
  "data_1":"The quick brown fox",
  "data_2":"jumps over the lazy dog"
}
signature = base64.b64decode("XRNTbkHK7H8XPEIJQhS6K6ncLPEuWWrkXLXiNWwv6ImnL2Dm5VHcazJ7QYQNOvWJmB2T3rconRkT0N4BDFapCQ==")

publicKey = load_der_public_key(publikKeyDer, default_backend())
r = int.from_bytes(signature[:32], byteorder='big')
s = int.from_bytes(signature[32:], byteorder='big')

try:
    publicKey.verify(
        encode_dss_signature(r, s),
        json.dumps(data, separators=(',', ':')).encode('utf-8'),
        ec.ECDSA(hashes.SHA256())    
    )
    print("verification succeeded")
except InvalidSignature:
    print("verification failed")