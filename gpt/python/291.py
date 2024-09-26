
     with open('/content/drive/My Drive/path_to_your_secrets_file.txt', 'r') as file:
         secrets = file.readlines()

     # Assuming your secrets file has each key on a new line:
     CLIENT_KEY = secrets[0].strip()
     CLIENT_SECRET = secrets[1].strip()
     BASE_URL =
