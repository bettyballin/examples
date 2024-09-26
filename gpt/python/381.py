
import base64
from cryptography.fernet import Fernet
import json

# ... your existing code ...

def firstruntrue():
    key = Fernet.generate_key()
    f = Fernet(key)
    userog = input("What is your Username? ").encode()
    encrypteduser = f.encrypt(userog)
    passwordog = input("What is your Password? ").encode()
    encryptedpassword = f.encrypt(passwordog)
    editjson("firstrun",
