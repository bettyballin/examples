
import getpass
import imaplib

# Prompt for the username and password
username = input('User name: ')
password = getpass.getpass()

# Convert password to a mutable bytearray
password_bytes = bytearray(password, 'utf-8')

# Use the credentials to login
MAIL_HOST = 'your.mail.host'
mail = imaplib.IMAP4(MAIL_HOST)
mail.login(username, password)

# Immediately after login, overwrite the password
for i in range(len(password_bytes)):
    password_bytes[i] = 0

# Continue
