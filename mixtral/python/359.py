from cryptography.fernet import Fernet
import base64
import json

def editjson(key, value):
    with open('data.json', 'r+') as file:
        data = json.load(file)
        data[key] = value
        file.seek(0)
        json.dump(data, file)
        file.truncate()

def firstruntrue():
    key = Fernet.generate_key()
    f = Fernet(key)

    userog = input("What is your Username? ")
    encrypteduser = base64.urlsafe_b64encode(f.encrypt(userog.encode())).decode('utf-8')

    passwordog = input("What is your Password? ")
    encryptedpassword = base64.urlsafe_b64encode(f.encrypt(passwordog.encode())).decode('utf-8')

    editjson("firstrun", False)
    editjson("user", encrypteduser)
    editjson("password", encryptedpassword)

    # Convert the key to base64 and store it in JSON
    encoded_key = base64.urlsafe_b64encode(key).decode('utf-8')
    editjson("key", encoded_key)

if __name__ == "__main__":
    firstruntrue()