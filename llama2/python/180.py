import requests

api_url = "https://crt.sh/api/v1/subdomains"
api_key = "YOUR_API_KEY"  # replace with your actual API key

# Set up the request headers
headers = {
    "Authorization": f"Bearer {api_key}",
    "User-Agent": "My Python Script",
    "Accept": "application/json"
}

# Set up the request parameters
params = {
    "domain": "example.com"  # replace with the domain you want to query
}

try:
    response = requests.get(api_url, headers=headers, params=params)
    response.raise_for_status()
    print(response.json())
except requests.exceptions.RequestException as e:
    print(f"An error occurred: {e}")