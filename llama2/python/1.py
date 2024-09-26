import os

def generate_salt(length=16):
    return os.urandom(length).hex()

# Create a salt for each user
user_name = "JohnDoe"
salt = generate_salt()

# Store the salt and username in a secure way
user_record = {'username': user_name, 'salt': salt}

print(user_record)