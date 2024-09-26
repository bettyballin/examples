import bcrypt

# assuming hashed_password is your stored BCrypt hash
hashed_password = b"$2a$10$.vGA1O9wmRjrwAVXD98HNO"

# user input
user_input = "my password".encode('utf-8')

# check if the hashes match
if bcrypt.checkpw(user_input, hashed_password):
    print("It's a Match!")
else:
    print("No Matches :(")