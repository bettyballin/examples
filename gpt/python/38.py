
import bcrypt

# To store a password
password = b"user_password"
salt = bcrypt.gensalt()
hashed_password = bcrypt.hashpw(password, salt)

# Store these in the database
store_in_db(username, hashed_password, salt)

# To verify a password
def verify_password
