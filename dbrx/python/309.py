import json
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend

class User:
    def __init__(self):
        self.private_key = ec.generate_private_key(ec.SECP256K1(), default_backend())
        self.public_key = self.private_key.public_key()

# Create a new User instance to test the class
user = User()
print(user.private_key)
print(user.public_key)