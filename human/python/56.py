import sqlite3

# Create a connection to the database
conn = sqlite3.connect('database.db')
cursor = conn.cursor()

# Define the table and values to insert
table = 'your_table_name'
args = ('value1', 'value2', 'value3')  # Replace with your actual values

# Create the table if it does not exist
cursor.execute(f"""CREATE TABLE IF NOT EXISTS {table} (
                    column1 TEXT,
                    column2 TEXT,
                    column3 TEXT
                )""")

# Execute the INSERT statement
cursor.execute(f"INSERT INTO {table} VALUES (?, ?, ?)", args)

# Commit the transaction
conn.commit()

# Close the connection
conn.close()