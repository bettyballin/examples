import requests
from requests.auth import HTTPBasicAuth

Data = {'username': 'natas16'}  # replace with your desired data
r = requests.post('http://natas15.natas.labs.overthewire.org/index.php?debug', 
                  auth=HTTPBasicAuth('natas15', 'AwWj0w5cvxrZiONgZ9J5stNVkmxdk39J'), 
                  data=Data, timeout=2)

print(r.text)