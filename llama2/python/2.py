import secretstorage
import getpass
import imaplib

MAIL_HOST = 'your_mail_host'  # replace with your mail host

username = raw_input('User name: ')
password = getpass.getpass()

# Encrypt and store password securely
store = secretstorage.Store()
encrypted_password = store.encrypt(password.encode('utf-8'))

mail = imaplib.IMAP4(MAIL_HOST)
mail.login(username, store.decrypt(encrypted_password).decode('utf-8'))

# After login erase the encrypted password from memory
del encrypted_password