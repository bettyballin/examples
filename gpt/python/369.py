
import json
from cryptography.fernet import Fernet

key = b'F9tdtAlS5kqVL5_uxKCnOPailXUqKsJmxbHWGLv_H-c='

with open('info.json', 'r') as loader1:
    params = json.load(loader1)

if xyz(x, y):
    fernet = Fernet(key)
    params_json = json.dumps(params)  # Convert the Python object to a JSON string
    encrypted = fernet.encrypt(params_json.encode('utf-8'))  # Encode the JSON string to bytes
    print(encrypted)
    with open('info.json', 'wb') as writer1:
        writer1.write(encrypted)  # Write bytes directly to file

    print("Operation was a
