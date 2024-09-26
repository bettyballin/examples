import sqlite3

# Connect to SQLite database. It will be created if it doesn't exist.
conn = sqlite3.connect('accounts.db')

# Create a cursor object
cursor = conn.cursor()

# Create table
cursor.execute('''
    CREATE TABLE IF NOT EXISTS accounts
    (user TEXT, password TEXT)
''')

# Define user and password
user = 'username'
password = 'password123'

# Insert into table
cursor.execute(f'INSERT INTO accounts VALUES(?, ?)', (user, password))

# Commit the changes
conn.commit()

# Close the connection
conn.close()