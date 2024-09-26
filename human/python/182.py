from cryptography.fernet import Fernet

def main():
    key = Fernet.generate_key()
    cipher_suite = Fernet(key)
    cipher_text = cipher_suite.encrypt(b"A really secret message. Not for prying eyes.")
    plain_text = cipher_suite.decrypt(cipher_text)

    print("Key:", key)
    print("Cipher Text:", cipher_text)
    print("Plain Text:", plain_text)

if __name__ == "__main__":
    main()