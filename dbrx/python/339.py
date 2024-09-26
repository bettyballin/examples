import getpass

def main():
    username = input("Enter your username: ")
    password = getpass.getpass(prompt="Enter your password: ")

    # Use these variables as needed...
    print(f"Username: {username}")
    print(f"Password: {'*' * len(password)}")

if __name__ == "__main__":
    main()