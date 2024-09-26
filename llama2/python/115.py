import configparser

def main():
    config = configparser.ConfigParser()
    config.read('C:\\Users\\PycharmProjects\\Integration\\local.ini')

    # Print all sections
    print(config.sections())

    # Get the value of 'server' from the 'db' section
    server = config.get('db', 'server')

    # Print the value of 'server'
    print(server)

if __name__ == "__main__":
    main()