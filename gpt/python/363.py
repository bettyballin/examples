
def encrypt(self, filename, key, folderName):
    full_path = os.path.join(folderName, filename)
    f = Fernet(key)

    with open(full_path, "rb") as file:
        file_data = file.read()

    encrypted_data = f.encrypt(file_data)

    with open(full_path, "wb") as file:
        file.write(encrypted_data)

