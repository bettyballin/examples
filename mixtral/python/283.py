from cryptography.fernet import Fernet, InvalidToken, InvalidSignature

key = Fernet.generate_key()

def validate_token(ciphertext):
    try:
        f = Fernet(key)
        decrypted_data = f.decrypt(ciphertext).decode()

        # If the code reaches this point then it's a valid token
        print("Valid token:", decrypted_data)

    except (InvalidToken, InvalidSignature) as e:
        # Handle invalid tokens here
        print("Invalid token:", e)

# Test the function
f = Fernet(key)
ciphertext = f.encrypt(b"Hello, World!")
validate_token(ciphertext)
validate_token(b"Invalid token")