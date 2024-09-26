import sqlite3

# Connect to or Create new Database
conn = sqlite3.connect('mydatabase.db', check_same_thread=False)

# Enable Cipher
conn.execute("PRAGMA key='your_password_here';")