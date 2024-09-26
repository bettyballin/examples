from cryptography.hazmat.primitives import serialization

public_key_bytes = b'...'  # insert your public key bytes here
apple_public_key = serialization.load_der_public_key(public_key_bytes)