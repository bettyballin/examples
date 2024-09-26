import os
from cryptography.fernet import Fernet

def view():
    fer = Fernet.generate_key()
    cipher_suite = Fernet(fer)

    if not os.path.isfile('passwords.txt'):
        print("No passwords stored.")
        return

    with open('passwords.txt', 'r') as f:
        for line in f.readlines():
            try:
                data = line.strip()
                user, passw = data.split("|")
                print(f"User:{user} | Password:{cipher_suite.decrypt(passw.encode()).decode()}")

            except ValueError as e:
                print(f"Error: {e}")
                # Handle the error here (e.g log it or display a message to user).
                pass

view()