
from configparser import ConfigParser

config = ConfigParser()
config.read('config.ini')

user = config.get('credentials', 'user')
pwd = config.get('credentials', 'password')

