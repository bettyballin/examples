from getpass import getuser
import crypt

def check_password(hash, password):
    salt = hash.split('$')[1] + '$' + hash.split('$')[2]
    return crypt.crypt(password, salt) == hash

# Example usage
unix_hashed_pwd = "$1$qwertyui$EfJKl7z80wMm4/WXjhH6N."
user_input_pwd  = "plaintext"

if check_password(unix_hashed_pwd, user_input_pwd):
    print("Password is correct")
else:
    print("Invalid password!")