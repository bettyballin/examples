import pyodbc
import getpass

# Define the connection string with placeholders for the username and password
connection_string = "DRIVER={MySQL ODBC 8 ANSI Driver};SERVER=my-sql-server;DATABASE=my-database;UID=%s;PWD=%s"

# Prompt the user for their username and password
userid = input('User: ')
password = getpass.getpass('Password for {}:'.format(userid))

# Create a connection object with the parameterized connection string
connection = pyodbc.connect(connection_string % (userid, password))

# Define the query using parameters
query = "SELECT * FROM my-table WHERE username = ? AND password = ?"

# Prepare and execute the query
cursor = connection.cursor()
cursor.execute(query, (userid, password))

# Fetch the results
results = cursor.fetchall()

# Print the data
print("Here's your data!")
for row in results:
    print(row)

# Close the connection
connection.close()