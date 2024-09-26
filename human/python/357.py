import configparser

def main():
    config = configparser.ConfigParser()
    config.read(r'C:\Users\PycharmProjects\Integration\local.ini')
    server = config['db']['server']
    print(server)

if __name__ == "__main__":
    main()