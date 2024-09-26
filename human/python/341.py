from passlib.context import CryptContext

# Set up password encryption
pwd_context = CryptContext(schemes=["bcrypt"], default="bcrypt", bcrypt__rounds=14)

def encrypt_password(password):
    return pwd_context.hash(password)

# Assuming you have a user_datastore object
user_datastore.create_user(email='email@email.com', password=encrypt_password("my_password"))