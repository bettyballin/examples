import sqlite3

# Create a connection to the database
con = sqlite3.connect('example.db')

# Create a cursor object
cur = con.cursor()

# Create the person table if it doesn't exist
cur.execute("CREATE TABLE IF NOT EXISTS person (firstname TEXT)")

# Execute the insert statement
cur.execute("INSERT INTO person (firstname) VALUES (?)", ("Joe",))

# Commit the changes
con.commit()

# Close the connection
con.close()