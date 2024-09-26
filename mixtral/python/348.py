import sqlite3

# Establish a connection to the database
connection = sqlite3.connect('database.db')
cursor = connection.cursor()

# Create table if it doesn't exist
cursor.execute('''
    CREATE TABLE IF NOT EXISTS accounts
    (user TEXT, password TEXT)
''')

# Insert data into the table
user = 'your_username'
password = 'your_password'
cursor.execute('INSERT INTO accounts VALUES (?, ?)', (user, password))

# Commit the changes and close the connection
connection.commit()
connection.close()