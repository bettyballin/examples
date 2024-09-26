from cryptography.fernet import Fernet
import os
import pathlib

def write_key():
    key = Fernet.generate_key()
    with open('key.key', "wb") as key_file:
        key_file.write(key)

def load_key():
    file = open('key.key', 'rb')
    key_ = file.read()
    file.close()
    return key_

write_key()  # generate and write key if it doesn't exist
key = load_key()
fer = Fernet(key)

os.chdir(r"C:\Users\{user}\encrypt_test".format(user=os.getlogin()))

for root, dirs, files in os.walk('.'):
    print(files)
    for filename in files:
        if filename == 'key.key':  # skip the key file
            continue
        filepath = pathlib.Path(root) / filename

        with open(filepath, 'rb') as f:
            data = f.read()

        with open(filepath, 'w') as f:
            print(len(data))
            f.write(fer.encrypt(data).decode())
            print('done')