
import configparser

# Create a ConfigParser instance
config = configparser.ConfigParser()

# Read the INI file
config.read(r'C:\Users\PycharmProjects\Integration\local.ini')

# Print all the sections to verify that they are being read correctly
print(config.sections())

# Access the values using the section and option names
server = config.get('db', 'server')
log = config.get('db', 'log')
login = config.get('Auth', 'login')

# Print the values to verify that they are being retrieved correctly
print('Server:', server)
print('Log:', log)
print('Login:', login)

