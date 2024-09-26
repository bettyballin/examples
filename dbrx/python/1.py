import spwd
import pam

def change_password(username, new_password):
    # Get the user's current shadow entry
    old_entry = spwd.getspnam(username)

    # Create a PAM service for changing passwords
    pamsrv = pam.pam()

    # Change the password using libpam
    result = pamsrv.chauthtok(username, new_password)

    if not result:
        raise Exception(f"Failed to change password: {result}")

# Usage example
change_password('username', 'new_secure_password')