import hashlib

def generate_key(date, case_id, name):
    password = f"{date}{case_id}{name}"
    salt = b"MySalt"
    iterations = 1000

    derived_key = hashlib.pbkdf2_hmac('sha256', password.encode(), salt, iterations)

    return derived_key[:16]

# Example usage:
date = "20230220"
case_id = "12345"
name = "JohnDoe"

key = generate_key(date, case_id, name)
print(key.hex())