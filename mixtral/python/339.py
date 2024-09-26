import base64
import json
from cryptography.fernet import Fernet

key = b'F9tdtAlS5kqVL5_uxKCnOPailXUqKsJmxbHWGLv_H-c='

with open('info.json', 'r') as loader1:
    params = json.load(loader1)

def xyz(x, y):
    # You need to implement this function
    pass

if xyz(None, None):  # Replace with actual arguments

    fernet = Fernet(key)

    # Convert JSON object to bytes
    encrypted = fernet.encrypt(bytes(json.dumps(params), 'utf-8'))

    print("Encrypted:", base64.b64encode(encrypted))

    with open('info_encrypted.bin', 'wb') as writer1:
        # Save encrypted data to a binary file
        writer1.write(encrypted)  # Don't decode before writing

    print("Operation was a success")
else:
    print("error")