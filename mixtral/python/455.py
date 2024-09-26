import os

# Set environment variables
os.environ['USERNAME'] = 'your_username'
os.environ['PASSWORD'] = 'your_password'

username = os.getenv('USERNAME')
password = os.getenv('PASSWORD')

# Use username & password
print(f"Username: {username}")
print(f"Password: {password}")