
from passlib.hash import sha512_crypt

# Hash a password
hashed_password = sha512_crypt.hash("mysecretpassword")

# Verify a password
is_correct = sha512_crypt.verify("mysecretpassword", hashed_password)

print(is_correct)  # This should print `True` if the verification is successful
