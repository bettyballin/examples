from werkzeug.security import generate_password_hash, check_password_hash

def main():
    password = input("Enter a password: ")
    hashed_password = generate_password_hash(password)
    print(f"Hashed Password: {hashed_password}")

    check_password = input("Enter password again to check: ")
    is_valid = check_password_hash(hashed_password, check_password)
    print(f"Is Password Valid? {is_valid}")

if __name__ == "__main__":
    main()