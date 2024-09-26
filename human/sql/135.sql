python
import sqlite3
import argparse

# Define the parser
parser = argparse.ArgumentParser()
parser.add_argument('--field1', type=str, required=True)
parser.add_argument('--field2', type=str, required=True)

# Parse the arguments
args = parser.parse_args()

# Connect to the SQLite database
conn = sqlite3.connect('database.db')
cursor = conn.cursor()

# Create table if it doesn't exist
cursor.execute('''
    CREATE TABLE IF NOT EXISTS tableX
    (field1 TEXT, field2 TEXT)
''')

# Insert data into tableX
cursor.execute('''
    INSERT INTO tableX (field1, field2)
    VALUES (?, ?)
''', (args.field1, args.field2))

# Commit the changes
conn.commit()

# Close the connection
conn.close()