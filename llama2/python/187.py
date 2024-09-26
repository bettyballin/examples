import cryptography.fernet as fernet

# Initialize Fernet with a secure password
key = fernet.Fernet.generate_key()
fernet = fernet.Fernet(key)

# Encrypt the SQLite3 database
with open('my_database.db', 'rb') as file:
    database_data = file.read()
encrypted_database = fernet.encrypt(database_data)

# Save the encrypted database to local storage
with open('encrypted_database.db', 'wb') as file:
    file.write(encrypted_database)

bash
# to run the script, save it as a python file, for example, `script.py` and run using
python script.py