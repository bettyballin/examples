from oauth2client.service_account import ServiceAccountCredentials

def main():
    scopes = ['https://www.googleapis.com/auth/sqlservice.admin']

    credentials = ServiceAccountCredentials.from_json_keyfile_name(
        '/path/to/keyfile.json', scopes=scopes)

    print(credentials)

if __name__ == "__main__":
    main()