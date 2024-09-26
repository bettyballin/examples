import base64
from cryptography.hazmat.primitives import serialization

def serialize_public_key(self):
    """Reset the public key to its serialized version."""
    return base64.b64encode(
        self.public_key.public_bytes(
            encoding=serialization.Encoding.PEM,
            format=serialization.PublicFormat.SubjectPublicKeyInfo
        )
    ).decode('utf-8')