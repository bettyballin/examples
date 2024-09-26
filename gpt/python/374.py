
import sqlite3

# Create the accounts table if it doesn't exist
def create_table():
    connection = sqlite3.connect('data.db')
    cursor = connection.cursor()
    cursor.execute('CREATE TABLE IF NOT EXISTS accounts(name text primary key, password text)')
    connection.commit()
    connection.close()

# Insert a new account into the database
def insert_account(user, password):
    connection = sqlite3.connect('data.db')
    cursor = connection.cursor()
    cursor.execute('INSERT INTO accounts (name, password) VALUES (?, ?)', (user, password))
    connection.commit()
    connection.close()

# Main logic to create accounts
def create_accounts():
    create_table()
    while True:
        yes_no_value = input("Would you like to create a new account? (yes/no): ")
        if yes_no_value.lower() == 'no':
            break

        user = input("Enter username: ")
        password = input("
