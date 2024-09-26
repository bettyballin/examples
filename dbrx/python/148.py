import requests

url = 'https://www.facebook.com/'
headers = {'User-Agent': 'Mozilla/5.0'}
response = requests.get(url, headers=headers)

if response.status_code == 200:
    print(response.headers)
else:
    print(f'Response status code: {response.status_code}')