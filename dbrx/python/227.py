from cryptography.fernet import Fernet

def generate_key():
    return Fernet.generate_key()

def encrypt_connection_string(connection_string, key):
    f = Fernet(key)
    return f.encrypt(connection_string.encode()).decode()

def decrypt_connection_string(encrypted_connection_string, key):
    f = Fernet(key)
    return f.decrypt(encrypted_connection_string.encode()).decode()

if __name__ == "__main__":
    key = generate_key()
    connection_string = "my_database_connection_string"
    encrypted_string = encrypt_connection_string(connection_string, key)
    decrypted_string = decrypt_connection_string(encrypted_string, key)
    print("Key:", key)
    print("Connection String:", connection_string)
    print("Encrypted String:", encrypted_string)
    print("Decrypted String:", decrypted_string)