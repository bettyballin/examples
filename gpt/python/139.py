
import time
from cryptography.fernet import Fernet

# Generate a key for encryption and decryption
# You should save this key securely; if you lose it, you will not be able to decrypt the data
key = Fernet.generate_key()
cipher_suite = Fernet(key)

# Prompt the user for a password
password = input("Please type a password: ").encode()  # Convert to bytes

# Encrypt the password
encrypted_password = cipher_suite.encrypt(password)

print("Your password has passed the verification!")
time.sleep(1)
print("Saving and encrypting password...")
time.sleep(2)

# Write the encrypted password to a file
with open("Passwords_log.txt", 'ab') as file:  # Notice
