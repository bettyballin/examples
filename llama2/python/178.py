import secrets

def nonzero_random_bytes(n: int) -> bytes:
    return bytes(byte for byte in secrets.token_bytes(n) if byte != 0x00)