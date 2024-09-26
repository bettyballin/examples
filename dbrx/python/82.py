import os
import requests
from dotenv import load_dotenv, find_dotenv

load_dotenv(find_dotenv())

# Set request parameters
url  = 'https://apiexample.com/test'
user = os.getenv('API_USER')
pwd = os.getenv('API_PWD')

# Set authentication headers
headers = {
    'Authorization': f"Basic {user}:{pwd}",
    'Content-Type': 'application/json'
}

# Send GET request
response = requests.get(url, headers=headers)

# Check if request was successful
if response.status_code == 200:
    print("Request successful!")
    print(response.json())
else:
    print("Request failed!")
    print(response.text)