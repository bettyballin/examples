
from cryptography.fernet import Fernet, InvalidToken
import base64

def is_value_encrypted(value, fernet_instance):
    try:
        # Check if the value is a valid Base64-encoded string
        if not isinstance(value, bytes):
            value = value.encode()
        base64.urlsafe_b64decode(value)
    except (TypeError, ValueError):
        # Not a valid Base64-encoded string
        return False

    try:
        # Try to decrypt the value
        fernet_instance
