import hashlib
import crypt

ctype = "6" #for sha512 (see man crypt)
salt = "qwerty"
insalt = '${}${}$'.format(ctype, salt)
password = "AMOROSO8282"

value1 = hashlib.sha512((salt + password).encode()).hexdigest()
value2 = crypt.crypt(password, insalt) #this one is correct

if not value1 == value2:
    print("{}\n{}\n\n".format(value1, value2))