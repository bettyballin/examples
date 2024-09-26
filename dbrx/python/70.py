from cryptography.fernet import Fernet

password = input("Please type a password: ")
key = Fernet.generate_key()
cipher_suite = Fernet(key)

encrypted_password = cipher_suite.encrypt(password.encode()).decode()

print(f"Your encrypted password is {encrypted_password}")

with open("Passwords_log.txt", "a") as f:
    f.write(encrypted_password + "\n")