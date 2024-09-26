import cryptography.fernet as fernet
import sqlite3

# Initialize Fernet with the same password
key = fernet.Fernet.generate_key()
cipher_suite = fernet.Fernet(key)

# Load the encrypted database from local storage
try:
    with open('encrypted_database.db', 'rb') as file:
        encrypted_data = file.read()
except FileNotFoundError:
    print("No encrypted database found.")
    exit()

# Decrypt the database
try:
    decrypted_data = cipher_suite.decrypt(encrypted_data)
except fernet.InvalidToken:
    print("Invalid token. Encryption and decryption keys may not match.")
    exit()

# Save the decrypted database to memory
try:
    with open('decrypted_database.db', 'wb') as file:
        file.write(decrypted_data)
    db = sqlite3.connect('decrypted_database.db')
except sqlite3.Error as e:
    print(f"An error occurred: {e}")
    exit()