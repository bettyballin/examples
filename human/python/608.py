from getpass import getpass

val = input("Do you want to enter your password secretly? (Y/N)\n")

if val.upper() == 'N':
    password = input("Enter your password that has good strength: ")
else:
    password = getpass("Secret mode!!! Enter your password that has good strength: ")

print("Your password is:", password)