
import secrets
import string

def generate_secure_token(length):
    alphabet = string.ascii_letters + string.digits
    token = ''.join(secrets.choice(alphabet) for i in range(length))
    return token

# Example usage:
token_length = 32  # You can choose the length you need
secure_token = generate_secure_token(token_length)
print(secure_token)

