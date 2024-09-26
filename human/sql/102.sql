import sqlite3

user_input = "Robert'); DROP TABLE Students; --"

# Create a connection to an in-memory database
conn = sqlite3.connect(':memory:')

# Create a cursor object
cur = conn.cursor()

# Create a table for demonstration purposes
cur.execute('''
    CREATE TABLE users (
        id INTEGER PRIMARY KEY,
        name TEXT
    )
''')

# Parameterized query to prevent SQL injection
query = 'SELECT * FROM users WHERE name = ?'

try:
    cur.execute(query, (user_input,))
    print(cur.fetchall())
except sqlite3.Error as e:
    print(f"An error occurred: {e}")

conn.close()