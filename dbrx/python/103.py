import secrets

def generate_password(length=12):
    """Generate a password with given length."""
    alphabet = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{}|;.<>?'
    return ''.join(secrets.choice(alphabet) for _ in range(length))

if __name__ == "__main__":
    password = generate_password()
    print(password)