from cryptography.fernet import Fernet

def read_key():
    with open("key.key", "rb") as key_file:
        return key_file.read()

key = Fernet(read_key())

with open("source", "rb") as src, open("destination", "wb") as dest:
    while True:
        chunk = src.read(4096)

        if len(chunk) == 0:
            break

        encrypted = key.encrypt(chunk)

        # Write the length of each ciphertext to be able
        # to read it back during decryption
        dest.write((len(encrypted)).to_bytes(4, byteorder="big"))

        # Then write the actual encrypted chunk
        dest.write(encrypted)