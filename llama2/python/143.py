import argon2

def hash_and_verify_password():
    # Hash a password
    password = "my_secret_password"
    salt = argon2.PasswordHasher().salt()
    hashed_password = argon2.PasswordHasher().hash(password)

    # Verify a password
    verifier = argon2.PasswordVerifier()
    verified = verifier.verify(hashed_password, password)
    print(verified)  # Output: True

if __name__ == "__main__":
    hash_and_verify_password()