import os

db_password = os.getenv('DB_PASSWORD')

# Set environment variable for demonstration purposes
os.environ['DB_PASSWORD'] = 'your_database_password'

# Now use db_password in your database connection
print(db_password)