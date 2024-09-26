import requests

url = 'https://your-server/api'
headers = {'Content-Type': 'application/json'}
data = {...}  # Your secure data

response = requests.post(url, headers=headers, json=data)

if response.status_code == 200:
    print('Data transmitted successfully')
else:
    print('Failed to transmit the data:', response.text)