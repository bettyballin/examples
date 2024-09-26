import bcrypt

def generate_bcrypted_password(plaintext):
    salt = bcrypt.gensalt()
    return bcrypt.hashpw(plaintext.encode('utf-8'), salt)

input_str = "myInputString"
hashed_value = generate_bcrypted_password(input_str).decode('utf-8')
print("Hashed value:", hashed_value)