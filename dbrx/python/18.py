import bcrypt

password = b"my_password"
hashed_password_from_db = b"$2b$12$sOmEhAsHeDpRoBaBlYvAlUe"

if bcrypt.checkpw(password, hashed_password_from_db):
    print("It's a match")
else:
    print("Not the same password")