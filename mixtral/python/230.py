import configparser

config = configparser.ConfigParser()

# Ensure that your path to local.ini file is correct
config.read('path_to_your_file/local.ini')

server = config['db']['server']
log    = config['db']['log']

print(f"Server: {server} Log: {log}")