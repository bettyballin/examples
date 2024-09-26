import hashlib

password = input("Please type a password: ")
hashed_password = hashlib.sha256(password.encode()).hexdigest()
print(f"Your hashed password is {hashed_password}")

with open("Passwords_log.txt", "a") as f:
    f.write(hashed_password + "\n")