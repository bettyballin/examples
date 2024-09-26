from cryptography.fernet import Fernet

# Check if the key exists
try:
    with open("Keys.txt", "rb") as file:
        Key = file.read()
except FileNotFoundError:
    # Generate a new key
    print('Creating and saving a new key...')

    Key = Fernet.generate_key()

    with open("Keys.txt", "wb") as file:
        file.write(Key)

print(f'The generated/loaded key is {Key}')