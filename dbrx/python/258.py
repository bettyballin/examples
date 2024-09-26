import bcrypt

def check_user(username, entered_password):
    # Assuming hashed_password is stored in a database or a dictionary
    users = {
        'user1': bcrypt.hashpw('password1'.encode('utf-8'), bcrypt.gensalt()),
        # Add more users here...
    }

    hashed_password = users.get(username)

    if hashed_password and bcrypt.checkpw(entered_password.encode('utf-8'), hashed_password):
        # Password matches - allow access
        print("Access granted")
    else:
        print("Access denied")

# Example usage:
check_user('user1', 'password1')