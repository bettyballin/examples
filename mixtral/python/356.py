import requests
from requests.auth import HTTPBasicAuth

session = requests.Session()

url = 'http://example.com'
username = 'your_username'
password = 'your_password'
data = {'key': 'value'}

response = session.post(url, auth=HTTPBasicAuth(username, password), data=data)

print(response.status_code)
print(response.text)