import time
import hashlib

password1 = input("Please type a password: ")
print("Your password has passed the verification!")
time.sleep(1)

# Hash the password
hashed_passwd = hashlib.sha256()
hashed_passwd.update(password1.encode())

print("Saving and encrypting password...")
time.sleep(2)

f = open("Passwords_log.txt", "a")
# Write the hashed password to file
f.write(hashed_passwd.hexdigest() + '\n')

f.close()
print("Done!")