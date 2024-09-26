import os
from cryptography.fernet import Fernet

def generate_key():
    return Fernet.generate_key()

def get_fernet(key=None):
    if key is None:
        key = os.environ.get('SECRET_KEY')
    assert key is not None, "No secret key provided"
    f = Fernet(key)
    return f

def encrypt(data: str) -> bytes:
    f = get_fernet()
    encrypted_data = f.encrypt(data.encode())
    return encrypted_data

def decrypt(encrypted_data: bytes) -> str:
    f = get_fernet()
    decrypted_data = f.decrypt(encrypted_data).decode()
    return decrypted_data

if __name__ == "__main__":
    key = generate_key()
    print("Generated Key:", key)
    os.environ['SECRET_KEY'] = key.decode()

    data = "Hello, World!"
    print("Original Data:", data)

    encrypted_data = encrypt(data)
    print("Encrypted Data:", encrypted_data)

    decrypted_data = decrypt(encrypted_data)
    print("Decrypted Data:", decrypted_data)