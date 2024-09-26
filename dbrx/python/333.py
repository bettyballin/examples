import sqlite3

# Assuming you have already connected to the database
conn = sqlite3.connect("your_database.db")
cursor = conn.cursor()

email = "example@example.com"  # Replace with the email you want to query
cursor.execute("SELECT email FROM credentials WHERE email = ?", (email,))

# Fetch the result
result = cursor.fetchone()
print(result)

# Close the connection
conn.close()