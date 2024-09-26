import string
import secrets

def generate_token(length=32):
    """Generate a secure token with the given length."""
    alphabet = string.ascii_letters + string.digits
    return ''.join(secrets.choice(alphabet) for _ in range(length))

if __name__ == "__main__":
    token = generate_token()
    print(token)