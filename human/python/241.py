import requests
from requests.auth import HTTPBasicAuth

s = requests.Session()

# Make the initial authentication request from a session object
s.get('https://omg.wtf/user', auth=HTTPBasicAuth('user', 'pass'))

# All subsequent requests from that session will include any cookies set in the initial response
r = s.get('http://omg.wtf/911')
print(r.text)