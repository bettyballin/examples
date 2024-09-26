import sqlite3

# assuming you have a database connection established
conn = sqlite3.connect("your_database.db")
cursor = conn.cursor()

email = "example@example.com"  # replace with your email variable
cursor.execute("SELECT email FROM credentials WHERE email = ?", (email,))

# fetch results
result = cursor.fetchone()
print(result)

# close connection
conn.close()