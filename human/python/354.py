import requests

url = "https://graph.microsoft.com/v1.0/security/alerts/.default"

response = requests.get(url)

print(response.json())