import os
from cryptography.fernet import Fernet, InvalidToken

DELIMITER = b'---CHUNK-DELIMITER---'

def encrypt_file(key, source_path, destination_path):
    key = Fernet(key)

    with open(source_path, "rb") as src:
        chunks = iter(lambda: src.read(4096), b"")
        encrypted_chunks = (key.encrypt(chunk) for chunk in chunks)
        combined_data = DELIMITER.join(encrypted_chunks)

    os.makedirs(os.path.dirname(destination_path), exist_ok=True)
    with open(destination_path, "wb") as dest:
        dest.write(combined_data)


def decrypt_file(key, source_path, destination_path):
    key = Fernet(key)

    def read_chunk(file_obj):
        chunk = file_obj.read(65536)  # Read larger blocks
        if not chunk or DELIMITER in chunk:  # Check for delimiter presence
            return None

        decrypted_data = b''
        while True:
            try:
                decrypted_data += key.decrypt(chunk)
                break
            except InvalidToken:
                pass
        return decrypted_data

    with open(source_path, "rb") as src, open(destination_path, "wb") as dest:
        chunks = iter(read_chunk, None)

        for chunk in chunks:
            if chunk is not None:
                dest.write(chunk)


# Usage example:

key = Fernet.generate_key()
encrypt_file(key, "/path/to/source.txt", "/path/to/destination.enc")
decrypt_file(key, "/path/to/destination.enc", "/path/to/output.decrypted.txt")