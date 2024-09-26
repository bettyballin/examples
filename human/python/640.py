import sqlite3

# assuming 'email' is a variable containing the email address
email = "example@example.com"

# connect to the database
conn = sqlite3.connect("your_database.db")
cursor = conn.cursor()

# execute the query
cursor.execute("SELECT email FROM credentials WHERE email = :myvar", {"myvar": email})

# fetch the result
result = cursor.fetchone()

# close the connection
conn.close()