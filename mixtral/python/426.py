from cryptography.fernet import Fernet

fer = Fernet.generate_key()

def create():
    name = input("Account Name: ")
    password = input("Enter Password: ")

    with open('passwords.txt', 'a') as f:
        encrypted_passw = fer.encrypt(password.encode()).decode()
        line = "{}|{}\n".format(name, encrypted_passw)
        f.write(line)

create()