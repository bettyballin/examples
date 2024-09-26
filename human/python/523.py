import requests
from requests.auth import HTTPBasicAuth

while True:
    try:
        Data = {}
        r = requests.post('http://natas15.natas.labs.overthewire.org/index.php?debug',
                          auth=HTTPBasicAuth('natas15', 'AwWj0w5cvxrZiONgZ9J5stNVkmxdk39J'), data=Data, timeout=2)
    except requests.exceptions.Timeout as err:
        print('trying again!')
        continue