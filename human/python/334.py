import requests
from requests_negotiate_sspi import HttpNegotiateAuth

auth = HttpNegotiateAuth()

call_string = "http://your_url.com/endpoint"  # replace with your URL
parameters = {"key": "value"}  # replace with your parameters

content = requests.post(call_string, json=parameters, auth=auth)

print(content.text)