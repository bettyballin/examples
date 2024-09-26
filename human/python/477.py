from cryptography.fernet import Fernet

def generate_key():
    key = Fernet.generate_key()
    with open('key.key','wb') as file:
        file.write(key)

def load_key():
    with open('key.key','rb') as file:
        return file.read()

def encrypt_data(key, filename):
    with open(filename,'rb') as f:
        data = f.read()
    fernet = Fernet(key)
    encrypted = fernet.encrypt(data)
    with open(filename,'wb') as f:
        f.write(encrypted)

def main():
    generate_key()
    key = load_key()
    filename = 'filename.json'
    encrypt_data(key, filename)

if __name__ == "__main__":
    main()