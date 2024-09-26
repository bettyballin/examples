from cryptography.fernet import Fernet

def read_key():
    with open("key.key", "rb") as key_file:
        return key_file.read()

key = Fernet(read_key())

with open("source", "rb") as src, open("destination", "wb") as dest:
    while True:
        # Read the length of ciphertext
        chunk_len_bytes = src.read(4)
        if not chunk_len_bytes:
            break
        chunk_len = int.from_bytes(chunk_len_bytes, byteorder="big")

        encrypted = src.read(chunk_len)

        decrypted = key.decrypt(encrypted)

        dest.write(decrypted)