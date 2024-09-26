
# Encrypt and save the salt
...
salt = os.urandom(16)
file = open("salt.txt", "wb")
file.write(salt)
file.close()
...

