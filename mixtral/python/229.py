import configparser

try:
    config = configparser.ConfigParser()
    config.read('path_to_your_file/local.ini')

    print(config['db']['server'])

except Exception as e:

    print("Error occurred:", str(e))