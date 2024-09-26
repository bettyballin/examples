
   import json

   with open('config.json', 'r') as config_file:
       config = json.load(config_file)
       username = config['username']
       password = config['password']
   
