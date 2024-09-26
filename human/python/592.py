import base64
import hashlib
from cryptography.hazmat.primitives import serialization, hashes
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.backends import default_backend
from cryptography.exceptions import InvalidSignature

public_key_b64 = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEWzC5lPNifcHNuKL+/jjhrtTi+9gAMbYui9Vv7TjtS7RCt8p6Y6zUmHVpGEowuVMuOSNxfpJYpnGExNT/eWhuwQ=="
signature_b64 = "XRNTbkHK7H8XPEIJQhS6K6ncLPEuWWrkXLXiNWwv6ImnL2Dm5VHcazJ7QYQNOvWJmB2T3rconRkT0N4BDFapCQ=="

public_key_bytes = base64.b64decode(public_key_b64)
signature_bytes = base64.b64decode(signature_b64)

public_key = serialization.load_der_public_key(
    public_key_bytes,
    backend=default_backend()
)

message = b"your message here"
try:
    public_key.verify(
        signature_bytes,
        message,
        padding.PSS(
            mgf=padding.MGF1(hashes.SHA256()),
            salt_length=padding.PSS.MAX_LENGTH
        ),
        hashes.SHA256()
    )
    print("The signature is valid.")
except InvalidSignature:
    print("The signature is not valid.")