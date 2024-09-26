import configparser

# Read from .ini
config = configparser.ConfigParser()
config.read('credentials.ini')

username = config['DEFAULT']['USERNAME']
password = config['DEFAULT']['PASSWORD']

# Use username & password
print("Username:", username)
print("Password:", password)