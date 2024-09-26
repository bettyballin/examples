python
import sqlite3

# Establish a connection to the database
conn = sqlite3.connect('database.db')

# Create a cursor object
cursor = conn.cursor()

# Create a table for demonstration purposes
cursor.execute("CREATE TABLE IF NOT EXISTS table (column1 TEXT)")

# Define the argument(s) to be inserted
args = ('value1',)

# Execute the INSERT query with parameter
cursor.execute("INSERT INTO table VALUES (?)", args)

# Commit the changes
conn.commit()

# Close the connection
conn.close()