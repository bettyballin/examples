import requests

subscription_id = "your_subscription_id"
access_token = "your_access_token"

url = f"https://management.azure.com/subscriptions/{subscription_id}/providers/Microsoft.Security/locations?api-version=2021-01-15-preview"

headers = {
    'Authorization': f'Bearer {access_token}'
}

response = requests.get(url, headers=headers)

if response.status_code == 200:
    asc_locations = [location['name'] for location in response.json()['value']]
    print(asc_locations)
else:
    print(f"Error: {response.text}")