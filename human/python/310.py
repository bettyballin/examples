import requests
import json

r = requests.post('http://127.0.0.1:5000/account/login', 
                  data=json.dumps({'email':'me.mine.com', 'password':'goodpw'}), 
                  headers={'content-type': 'application/json'})

print(r.json())