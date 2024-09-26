from cryptography.fernet import Fernet

class Encryptor:
    def encrypt(self, abs_filename, key):
        f = Fernet(key)

        with open(abs_filename, "rb") as file:
            file_data = file.read()

        encrypted_data = f.encrypt(file_data)

        # Write the data back to the same absolute path
        with open(abs_filename, "wb") as file:
            file.write(encrypted_data)

# Example usage:
encryptor = Encryptor()
encryptor.encrypt("/path/to/file", "your_secret_key_here")