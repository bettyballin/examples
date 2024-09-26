from cryptography.hazmat.primitives.serialization import load_der_public_key
import base64

ephemeral_public_key = "your_base64_encoded_public_key_here"
public_key = load_der_public_key(base64.b64decode(ephemeral_public_key))