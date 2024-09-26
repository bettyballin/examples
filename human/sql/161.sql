import sqlite3

# assuming email is a variable holding the email to be queried
email = "example@example.com"

# assuming a connection to the database has been established
conn = sqlite3.connect("database.db")
cursor = conn.cursor()

cursor.execute("SELECT email FROM credentials WHERE email = ?", (email,))

# fetching the result
result = cursor.fetchone()
print(result)

# closing the connection
conn.close()