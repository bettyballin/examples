from cryptography.fernet import Fernet

class Encryptor(object):
    def __init__(self, secret_key=None):
        if not secret_key:
            self.secret_key = Fernet.generate_key()
        else:
            self.secret_key = bytes(secret_key.encode())

        self.encryptor = Fernet(self.secret_key)

    def encrypt(self, data):
        return self.encryptor.encrypt(data.encode()).decode()

    def decrypt(self, encrypted_data):
        decrypted_data = self.encryptor.decrypt(encrypted_data.encode())
        return decrypted_data.decode()

def main():
    encryptor = Encryptor()
    data = "Hello, World!"
    print("Original Data:", data)

    encrypted_data = encryptor.encrypt(data)
    print("Encrypted Data:", encrypted_data)

    decrypted_data = encryptor.decrypt(encrypted_data)
    print("Decrypted Data:", decrypted_data)

if __name__ == "__main__":
    main()