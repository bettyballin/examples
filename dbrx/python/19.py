import sqlite3

# Create an in-memory SQLite database
conn = sqlite3.connect(":memory:")
cursor = conn.cursor()

# Execute SQL commands as needed e.g creating tables and inserting records
cursor.execute("CREATE TABLE accounts (name TEXT PRIMARY KEY, password TEXT)")
cursor.executemany(
    "INSERT INTO accounts VALUES (?, ?)", [("user1", "password1"), ("user2", "password2")]
)

conn.commit()

# Access the data as needed
cursor.execute("SELECT * FROM accounts")
print(cursor.fetchall())

# Close the connection when done
conn.close()