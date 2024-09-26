import bcrypt

def main():
    # Hash a password
    password = "my_secret_password"
    hashed_password = bcrypt.hashpw(password.encode(), bcrypt.gensalt())

    # Verify a password
    verified = bcrypt.checkpw("my_secret_password".encode(), hashed_password)
    print(verified)  # Output: True

if __name__ == "__main__":
    main()