import sqlcipher

conn = sqlcipher.connect('my_database.db')
conn.execute("PRAGMA key='your-password'")
cursor = conn.cursor()

# Create table and insert data
table_query = """
CREATE TABLE IF NOT EXISTS passwords (
    id INTEGER PRIMARY KEY,
    website TEXT UNIQUE,
    username TEXT,
    password TEXT
);
"""

cursor.execute(table_query)
conn.commit()
conn.close()