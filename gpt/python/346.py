
from cryptography.fernet import Fernet, InvalidToken

try:
    # Code here to create key from a password
    f = Fernet(key)
    token = f.decrypt(data)
except InvalidToken:
    print("wow")

