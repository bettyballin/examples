import sqlite3
from getpass import getpass
from passlib.hash import sha256_crypt

def create_user(username, password):
    salt = sha256_crypt.using(salt=None).generate(password)

    db = sqlite3.connect("test.db")

    with db:
        cursor = db.cursor()

        query = "INSERT INTO LOGIN (USER, PASSWORD) VALUES (?, ?)"

        try:
            cursor.execute(query, (username, salt))

        except sqlite3.IntegrityError as e:

            print("Username already exists.")

def login_user():
    username = input('Enter your Username: ')

    password = getpass()

    db = sqlite3.connect("test.db")

    with db:
        cursor = db.cursor()

        query = "SELECT PASSWORD FROM LOGIN WHERE USER=? "

        try:
            result = cursor.execute(query, (username,))

            stored_password = result.fetchone()[0]

            if sha256_crypt.verify(password, stored_password):
                print('Welcome')

            else:

                print("Invalid password.")

        except sqlite3.OperationalError as e:

            print("User does not exist")

        except TypeError as e:
            print("User does not exist")

# Create table if not exists
db = sqlite3.connect("test.db")
cursor = db.cursor()
cursor.execute("CREATE TABLE IF NOT EXISTS LOGIN (USER TEXT PRIMARY KEY, PASSWORD TEXT)")
db.commit()
db.close()

# Create a new user
create_user('test', 'mypassword123456789')

while True:
    login_user()