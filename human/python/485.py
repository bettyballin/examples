import hashlib
import base64
from getpass import getpass
from cryptography.fernet import Fernet
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC

def generate_key(password):
    password = password.encode()
    salt = b'salt_'
    kdf = PBKDF2HMAC(
        algorithm=hashes.SHA256(),
        length=32,
        salt=salt,
        iterations=100000,
    )
    key = base64.urlsafe_b64encode(kdf.derive(password))
    return key

def encrypt_text(key, text):
    cipher_suite = Fernet(key)
    cipher_text = cipher_suite.encrypt(text.encode())
    return cipher_text.decode()

def decrypt_text(key, cipher_text):
    cipher_suite = Fernet(key)
    plain_text = cipher_suite.decrypt(cipher_text.encode())
    return plain_text.decode()

def main():
    password = input("Enter your key: ")
    key = generate_key(password)
    
    while True:
        print("\nPlease select option:")
        print("1. Encryption")
        print("2. Decryption")
        print("3. Exit")
        option = input("Choose a option: ")

        if option == "1":
            text = input("Please enter your text: ")
            cipher_text = encrypt_text(key, text)
            print(f"Encrypted text: {cipher_text}")
        elif option == "2":
            cipher_text = input("Please enter your cipher text: ")
            try:
                plain_text = decrypt_text(key, cipher_text)
                print(f"Decrypted text: {plain_text}")
            except Exception as e:
                print("Invalid cipher text or key.")
        elif option == "3":
            print("Quitting The Program....")
            break
        else:
            print("Invalid option. Please choose a valid option.")

if __name__ == "__main__":
    main()