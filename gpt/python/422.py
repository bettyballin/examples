
import secrets

def nonzero_random_bytes(n: int) -> bytes:
    # Generate a random bytes sequence
    random_bytes = bytearray(secrets.token_bytes(n))

    # Replace any zero bytes with a new random nonzero byte
    for i, byte in enumerate(random_bytes):
        while byte == 0:
            random_bytes[i] = secrets.randbelow(256)
            byte = random_bytes[i]

    # Convert the bytearray back to bytes
    return bytes(random_bytes)

