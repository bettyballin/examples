
import hashlib
from base64 import b64encode, b64decode

def generate_aes_key(date, case_id, name):
    # Combine the input variables into a single string.
    combined_input = f"{date}-{case_id}-{name}"

    # Hash the combined string using SHA-256.
    hasher = hashlib.sha256()
    hasher.update(combined_input.encode('utf-8'))
    hash_bytes = hasher.digest()

    # Truncate or expand the hash to the desired AES key size (e.g., 16 bytes for AES-128).
    # For AES-256, you would use
