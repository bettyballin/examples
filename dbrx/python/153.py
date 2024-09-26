import keyring
import requests
from requests_ntlm import HttpNtlmAuth

service_name = "MyService"
username = config.ServiceAccount["Username"]

# Retrieve the stored credential when needed without exposing it as plain text.
password = keyring.get_password(service_name, username)

auth = HttpNtlmAuth(username, password)
content = requests.post(call_string, json=parameters, auth=auth)