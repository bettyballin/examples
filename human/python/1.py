import hashlib
import getpass

class User:
    def __init__(self, stored_salt, stored_password_hash):
        self.stored_salt = stored_salt
        self.stored_password_hash = stored_password_hash

def sha1(string):
    return hashlib.sha1(string.encode()).hexdigest()

user = User("stored_salt_value", "stored_password_hash_value")
entered_password = getpass.getpass("Enter password: ")

string_to_hash = user.stored_salt + entered_password
successful_login = (sha1(string_to_hash) == user.stored_password_hash)

print(successful_login)