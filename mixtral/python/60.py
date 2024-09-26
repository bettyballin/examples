import os
import bcrypt

def create_hash(plaintext):
    salt = bcrypt.gensalt()
    return bcrypt.hashpw(plaintext.encode('utf-8'), salt)

hashed_password = create_hash("mysecretpassword")
print(hashed_password)