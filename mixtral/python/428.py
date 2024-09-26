from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend
import base64

# Generate a private key
private_key = ec.generate_private_key(ec.SECP256R1(), default_backend())

data = b"example_data"
signature = private_key.sign(data, ec.ECDSA(hashes.SHA256()))

# To send the signature to JavaScript
encoded_sig = base64.b64encode(signature)