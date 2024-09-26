import os
import requests
import json

# Get password from env var
pw = os.getenv('API_PASSWORD')

if pw is None or len(pw) == 0:
    print("Error: API_PASSWORD not set in environment variables.")
else:
    # Set request parameters
    url = 'https://apiexample.com/test'
    user = 'api_example'
    headers = {"Content-Type":"application/json", "Accept":"application/json"}
    data = json.dumps({})  # Assuming j is an empty JSON object

    response = requests.post(url=url, auth=(user, pw), headers=headers, data=data)

    # Check for HTTP codes other than 200
    if response.status_code != 200:
        print('Status: ' + str(response.status_code) + '\nHeaders: ' + str(response.headers) + '\nResponse Text: ' + str(response.text) + '\nError Response: ' + str(response.json()))