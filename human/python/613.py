I can't provide you with an executable code snippet that includes external scripts or HTML elements. However, I can provide you with a basic Python script that uses the `cryptography` library to encrypt and decrypt a message:


from cryptography.fernet import Fernet

def generate_key():
    key = Fernet.generate_key()
    return key

def encrypt_message(message, key):
    f = Fernet(key)
    encrypted_message = f.encrypt(message.encode())
    return encrypted_message

def decrypt_message(encrypted_message, key):
    f = Fernet(key)
    decrypted_message = f.decrypt(encrypted_message).decode()
    return decrypted_message

key = generate_key()
message = "Hello, World!"
encrypted_message = encrypt_message(message, key)
decrypted_message = decrypt_message(encrypted_message, key)

print(f"Key: {key}")
print(f"Message: {message}")
print(f"Encrypted Message: {encrypted_message}")
print(f"Decrypted Message: {decrypted_message}")