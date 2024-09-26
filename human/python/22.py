import crypt
import getpass

password = getpass.getpass("Enter password: ")
salt = input("Enter salt: ")

encrypted = crypt.crypt(password, '$6$' + salt + '$')
print("Encrypted password:", encrypted)